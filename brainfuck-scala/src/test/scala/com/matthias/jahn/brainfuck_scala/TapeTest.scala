package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.BeforeAndAfterEach

@RunWith(classOf[JUnitRunner])
class TapeTest extends FunSuite with ShouldMatchers with BeforeAndAfterEach{
	
	var tape: Tape = _
	
	override def beforeEach() {
		tape = new Tape()
	}

	test("value of new tape should be 0") {
		tape.currentValue should be (0)
	}
	
	test("value of new tape incremented once should be 1") {
		tape.increment()
		
		tape.currentValue should be (1)
	}
	
	test("initial value of left spot should be 0"){
		tape.increment()
		tape.moveLeft()
		
		tape.currentValue should be (0)
	}
	
	test("initial value of right spot should be 0"){
		tape.increment()
		tape.moveRight()
		
		tape.currentValue should be (0)
	}
	
	test("value of a spot should be persistent between moves"){
		tape.increment()
		
		tape.moveLeft()
		tape.moveRight()
		tape.moveRight()
		tape.moveLeft()
		
		tape.currentValue should be (1)
	}
}