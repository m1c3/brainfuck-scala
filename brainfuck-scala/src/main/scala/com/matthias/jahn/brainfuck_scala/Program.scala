package com.matthias.jahn.brainfuck_scala

class Program extends CompositeCommand {

  def execute(tape: Tape): Unit = { 
	  for(c <- childCommands){
	 	  c.execute(tape)
	  }
  }

}