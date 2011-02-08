package com.matthias.jahn.brainfuck_scala

class PlusCommand extends Command {

  def execute(tape: Tape): Unit = {
    tape.increment
  }

}