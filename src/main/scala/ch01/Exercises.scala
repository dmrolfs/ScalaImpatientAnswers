package ch01

import scala.math.BigInt._
import scala.util.Random

object Exercises extends App {
  val ex07 = probablePrime( 100, Random )
  println( s"ex07: probable prime = ${ex07}" )

  val str = "Hello World"
  println( s"""ex09: first character in "Hello World" is: ${str.head}""")
  println( s"""ex09: last character in "Hello World" is: ${str.last}""")
}
