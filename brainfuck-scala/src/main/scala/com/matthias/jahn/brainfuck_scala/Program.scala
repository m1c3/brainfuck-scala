package com.matthias.jahn.brainfuck_scala

class Program(private val tape: Tape) extends CompositeCommand {

  def execute() {
    execute(tape)
  }

  def execute(tape: Tape): Unit = {
    for (c <- childCommands) {
      c.execute(tape)
    }
  }

}