package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class CompositeCommandTest extends FunSuite with ShouldMatchers {

	test("a fresh CompositeCommand should have no childs"){
		val cmd: CompositeCommand = new {} with CompositeCommand{
			override def execute(tape: Tape) {}
		}
		
		cmd.childCommands.hasNext should be (false)
	}
	
	test("adding commands to the composite"){
		val child1 = new PlusCommand()
		val child2 = new MinusCommand()
		val cmd: CompositeCommand = new {} with CompositeCommand{
			override def execute(tape: Tape) {}
		}
		
		cmd.addChildCommand(child1)
		cmd.addChildCommand(child2)
		val iter = cmd.childCommands
		
		iter.next should be (child1)
		iter.next should be (child2)
	}
}