package com.matthias.jahn.brainfuck_scala

import java.io.Reader
import java.io.Writer

/**
 * The brainfuck '+' command.
 *
 * @author Matthias Jahn
 *
 */
class PlusCommand extends Command {

  override def execute(tape: Tape) {
    tape.increment()
  }
}

/**
 * The brainfuck '-' command.
 *
 * @author Matthias Jahn
 *
 */
class MinusCommand extends Command {
  override def execute(tape: Tape) {
    tape.decrement()
  }
}

/**
 * The brainfuck '<' command.
 *
 * @author Matthias Jahn
 *
 */
class MoveLeftCommand extends Command {
  override def execute(tape: Tape) {
    tape.moveLeft()
  }
}

/**
 * The brainfuck '>' command.
 *
 * @author Matthias Jahn
 *
 */
class MoveRightCommand extends Command {
  override def execute(tape: Tape) {
    tape.moveRight()
  }
}

/**
 * The brainfuck ',' command.
 *
 * @author Matthias Jahn
 *
 */
class ReadCommand(private val reader: Reader) extends Command {
  override def execute(tape: Tape) {
    tape.currentValue = reader.read
  }
}

/**
 * The brainfuck '.' command.
 * 
 * @author Matthias Jahn
 *
 */
class WriteCommand(private val writer: Writer) extends Command {
	override def execute(tape: Tape) {
		writer.write(tape.currentValue)
	}
}