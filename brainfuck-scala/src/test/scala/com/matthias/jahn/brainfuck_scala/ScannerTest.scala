package com.matthias.jahn.brainfuck_scala

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class ScannerTest extends FunSuite with ShouldMatchers{
	test("scanning empty String"){
		val iter = Scanner.createIterator("")
		
		iter.hasNext should be (false)
	}
	
	test("scanning simple BF program"){
		val iter = Scanner.createIterator("+-<")
		
		iter.next should be ('+')
		iter.next should be ('-')
		iter.next should be ('<')
		iter.hasNext should be (false)
	}
	
	test("scanning simple BF program with comments"){
		val iter = Scanner.createIterator("Foo: +-< cool!!!")
		
		iter.next should be ('+')
		iter.next should be ('-')
		iter.next should be ('<')
		iter.hasNext should be (false)
	}
}