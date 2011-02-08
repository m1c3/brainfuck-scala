package com.matthias.jahn.brainfuck_scala

/**
 * The while loop for a brainfuck programm. The loop executes the child commands, until the the current value of the tape is 0 in the loop-condition.
 *
 * @author Matthias Jahn
 *
 */
class WhileCommand extends CompositeCommand {

  override def execute(tape: Tape): Unit = {
    while (tape.currentValue != 0) {
      for (cmd <- childCommands) {
        cmd.execute(tape)
      }
    }
  }

}