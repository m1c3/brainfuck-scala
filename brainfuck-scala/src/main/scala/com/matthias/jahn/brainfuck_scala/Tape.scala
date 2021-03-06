package com.matthias.jahn.brainfuck_scala
import scala.collection.mutable

/**
 * The representation of the tape, a brainfuck programm is running on.
 *
 * @author Matthias Jahn
 */
class Tape {

  private val left = new mutable.Stack[Int]()
  private val right = new mutable.Stack[Int]()
  private var value = 0

  def currentValue = value
  def currentValue_=(value: Int) { this.value = value }

  def increment() { value += 1 }
  def decrement() { value -= 1 }

  def moveLeft() {
    right.push(value)

    if (left.isEmpty) {
      value = 0
    } else {
      value = left.pop
    }
  }

  def moveRight() {
    left.push(value)

    if (right.isEmpty) {
      value = 0
    } else {
      value = right.pop
    }
  }
}