package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.ShouldMatchers
import java.io.StringReader
import java.io.StringWriter

@RunWith(classOf[JUnitRunner])
class SimpleCommandsTest extends FunSuite with ShouldMatchers with BeforeAndAfterEach {

  var tape: Tape = _

  override def beforeEach() {
    tape = new Tape()
  }

  test("x command should increment current value") {
    val cmd = new PlusCommand()

    cmd.execute(tape)

    tape.currentValue should be(1)
  }

  test("- command should increment current value") {
    val cmd = new MinusCommand()
    tape.increment()
    tape.increment()

    cmd.execute(tape)

    tape.currentValue should be(1)
  }

  test("< command should move one step to the left") {
    val cmd = new MoveLeftCommand()
    tape.moveLeft()
    tape.increment()
    tape.moveRight()

    cmd.execute(tape)

    tape.currentValue should be(1)
  }

  test("> command shuld one step on the right") {
    val cmd = new MoveRightCommand()
    tape.moveRight()
    tape.increment()
    tape.moveLeft()

    cmd.execute(tape)

    tape.currentValue should be(1)
  }

  test(", command should read a char and write it to the current value") {
    val cmd = new ReadCommand(new StringReader("A"))

    cmd.execute(tape)

    tape.currentValue should be('A')
  }

  test(". command should read current value") {
    val writer = new StringWriter()
    val cmd = new WriteCommand(writer)
    tape.currentValue = 'Z'

    cmd.execute(tape)
    
    writer.getBuffer.toString should equal ("Z")
  }
}