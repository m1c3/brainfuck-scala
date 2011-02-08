package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import java.io.StringWriter

@RunWith(classOf[JUnitRunner])
class WhileCommandTest extends FunSuite with ShouldMatchers {

  test("loop should skip") {
    val writer = new StringWriter()
    val tape = new Tape()
    val cmd = new WhileCommand()

    cmd.addChildCommand(new WriteCommand(writer))
    cmd.execute(tape)

    writer.getBuffer should have length (0)
  }

  test("loop one run") {
    val writer = new StringWriter()
    val tape = new Tape()
    tape.increment()
    val cmd = new WhileCommand()

    cmd.addChildCommand(new WriteCommand(writer))
    cmd.addChildCommand(new MinusCommand())
    cmd.execute(tape)

    writer.getBuffer should have length (1)
  }
}