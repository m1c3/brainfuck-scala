package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Assertions

@RunWith(classOf[JUnitRunner])
class ParserTest extends FunSuite with ShouldMatchers {

  test("parsing '+' should produce PlusCommand") {
    val parser = new Parser("+".iterator)
    
    val program = parser.parse
    val iter = program.childCommands
    
    assert(iter.next.isInstanceOf[PlusCommand])
  }
  
  test("parsing '-' should produce MinusCommand") {
    val parser = new Parser("-".iterator)
    
    val program = parser.parse
    val iter = program.childCommands
    
    assert(iter.next.isInstanceOf[MinusCommand])
  }
  
  test("parsing '<' should produce MoveLeftCommand") {
    val parser = new Parser("<".iterator)
    
    val program = parser.parse
    val iter = program.childCommands
    
    assert(iter.next.isInstanceOf[MoveLeftCommand])
  }
  
  test("parsing '>' should produce MoveRightCommand") {
    val parser = new Parser(">".iterator)
    
    val program = parser.parse
    val iter = program.childCommands
    
    assert(iter.next.isInstanceOf[MoveRightCommand])
  }
  
  test("parsing '[]' should produce WhileCommand") {
    val parser = new Parser("[]".iterator)
    
    val program = parser.parse
    val iter = program.childCommands
    
    assert(iter.next.isInstanceOf[WhileCommand])
  }
  
  test("parsing '[' should throw SyntaxException"){
	  val parser = new Parser("[".iterator)
	   
	   evaluating {parser.parse } should produce [SyntaxException]
  }
  
  test("parsing '[+]'") {
    val parser = new Parser("[+]".iterator)
    
    val program = parser.parse
    val iter = program.childCommands
    
    val whileCmd = iter.next.asInstanceOf[WhileCommand]
    assert(whileCmd.childCommands.next.isInstanceOf[PlusCommand])
  }
}