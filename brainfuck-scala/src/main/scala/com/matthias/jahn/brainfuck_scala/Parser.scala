package com.matthias.jahn.brainfuck_scala

class Parser(private val iter: Iterator[Char]) {
  private var currentChar: Char = _

  def parse(): Program = {
    val program: Program = new Program()

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
    	}
    }

    return false
  }

}