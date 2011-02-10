package com.matthias.jahn.brainfuck_scala
import scala.io.Source
import java.io.InputStreamReader
import java.io.OutputStreamWriter

object App {
  def main(args: Array[String]): Unit = {
    if (args.length < 1) {
      println("filename of brainfuck program required")
      return
    }

    val src = Source.fromFile(args(0)).mkString
    val tokens = Scanner.createIterator(src)

    val parser = createParser()
    
    val program = parser.parse(tokens)
    
    program.execute()
  }

  private def createParser() = {
    val in = new InputStreamReader(System.in)
    val out = new OutputStreamWriter(System.out)

    new Parser(in, out)
  }

}
