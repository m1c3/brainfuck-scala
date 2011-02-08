package com.matthias.jahn.brainfuck_scala

import scala.collection.mutable.ListBuffer

/**
 * A CompositeCommand contains an amount of child commands.
 * 
 * @author Matthias Jahn
 *
 */
trait CompositeCommand extends Command {

  private val commands = new ListBuffer[Command]()

  def addChildCommand(cmd: Command) {
    commands += cmd
  }
  
  protected[brainfuck_scala] def childCommands = commands.iterator
}