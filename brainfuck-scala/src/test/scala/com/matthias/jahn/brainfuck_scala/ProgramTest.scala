package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class ProgramTest extends FunSuite with ShouldMatchers{

	test("empty program should do nothing"){
		val tape = new Tape()
		val program = new Program(tape)
		
		program.execute()
		
		tape.currentValue should be (0)
	}
	
	test("program should execute all given commands"){
		val tape = new Tape()
		val program = new Program(tape)
		
		program.addChildCommand(new PlusCommand())
		program.addChildCommand(new PlusCommand())
		program.addChildCommand(new MoveRightCommand())
		program.addChildCommand(new PlusCommand())
		program.execute()
		
		tape.currentValue should be (1)
		tape.moveLeft()
		tape.currentValue should be (2)
		
	}
}