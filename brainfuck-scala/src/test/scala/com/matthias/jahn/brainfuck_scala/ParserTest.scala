package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Assertions
import java.io.StringWriter
import java.io.StringReader

@RunWith(classOf[JUnitRunner])
class ParserTest extends FunSuite with ShouldMatchers {
  val dummyWriter = new StringWriter()
  val dummyReader = new StringReader("")

  test("parsing '+' should produce PlusCommand") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse("+".iterator)
    val iter = program.childCommands

    assert(iter.next.isInstanceOf[PlusCommand])
  }

  test("parsing '-' should produce MinusCommand") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse("-".iterator)
    val iter = program.childCommands

    assert(iter.next.isInstanceOf[MinusCommand])
  }

  test("parsing '<' should produce MoveLeftCommand") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse("<".iterator)
    val iter = program.childCommands

    assert(iter.next.isInstanceOf[MoveLeftCommand])
  }

  test("parsing '>' should produce MoveRightCommand") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse(">".iterator)
    val iter = program.childCommands

    assert(iter.next.isInstanceOf[MoveRightCommand])
  }

  test("parsing '.' should produce WriteCommand") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse(".".iterator)
    val iter = program.childCommands

    assert(iter.next.isInstanceOf[WriteCommand])
  }

  test("parsing ',' should produce ReadCommand") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse(",".iterator)
    val iter = program.childCommands

    assert(iter.next.isInstanceOf[ReadCommand])
  }

  test("parsing '[]' should produce WhileCommand") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse("[]".iterator)
    val iter = program.childCommands

    assert(iter.next.isInstanceOf[WhileCommand])
  }

  test("parsing '[' should throw SyntaxException") {
    val parser = new Parser(dummyReader, dummyWriter)

    evaluating { parser.parse("[".iterator) } should produce[SyntaxException]
  }

  test("parsing '[+]'") {
    val parser = new Parser(dummyReader, dummyWriter)

    val program = parser.parse("[+]".iterator)
    val iter = program.childCommands

    val whileCmd = iter.next.asInstanceOf[WhileCommand]
    assert(whileCmd.childCommands.next.isInstanceOf[PlusCommand])
  }
}