package com.matthias.jahn.brainfuck_scala

/**
 * A brainfuck command operating on the tape.
 * 
 * @author Matthais Jahn
 *
 */
trait Command {
	def execute(tape: Tape)
}