package com.matthias.jahn.brainfuck_scala

import scala.collection.Iterator

object Scanner  {

	def createIterator(s: String) = {
		s.iterator.filter(isScalaSymbol)
	}
	
	private def isScalaSymbol(c: Char) = {
		c match{
			case '+' => true
			case '-' => true
			case '<' => true
			case '>' => true
			case '.' => true
			case ',' => true
			case _ => false
		}
	}
}