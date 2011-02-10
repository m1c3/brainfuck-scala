package com.matthias.jahn.brainfuck_scala

import java.io.Reader
import java.io.Writer

class Parser(private val in: Reader, private val out: Writer) {
  private var currentChar: Char = _
  private var iter: Iterator[Char] = _

  def parse(iter: Iterator[Char]): Program = {
	this.iter = iter
    val program: Program = new Program(new Tape())

    while (iter.hasNext) {
      currentChar = iter.next

      parseCommand(program)
    }

    return program
  }

  private def parseCommand(parent: CompositeCommand) = {
    parseSimpleCommand(parent) || parseWhileCommand(parent)
  }

  private def parseSimpleCommand(parent: CompositeCommand): Boolean = {
    currentChar match {
      case '+' => parent.addChildCommand(new PlusCommand())
      case '-' => parent.addChildCommand(new MinusCommand())
      case '<' => parent.addChildCommand(new MoveLeftCommand())
      case '>' => parent.addChildCommand(new MoveRightCommand())
      case '.' => parent.addChildCommand(new WriteCommand(out))
      case ',' => parent.addChildCommand(new ReadCommand(in))
      case _ => return false
    }

    return true
  }

  private def parseWhileCommand(parent: CompositeCommand): Boolean = {
    if (currentChar != '[') {
      return false
    }
    
    val cmd = new WhileCommand()
    
    while(iter.hasNext){
    	currentChar = iter.next
    	
    	if(currentChar == ']'){
    		parent.addChildCommand(cmd)
    		return true
    	} else {
    		parseCommand(cmd)
    	}
    }
    
    throw new SyntaxException
  }

}