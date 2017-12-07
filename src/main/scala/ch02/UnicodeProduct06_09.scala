package ch02

import scala.annotation.tailrec

object UnicodeProduct06_09 extends App {
  def unicodeProductByFoldLeft( str: String ): Long = {
//    str.foldLeft( 1L ){ _ * _.toLong }
    str.foldLeft( 1L ){ (acc, c) => acc * c.toLong }
  }



  def unicodeProductByFor( str: String ): Long = {
    var x = 1L
    for { c <- str } { x *= c.toLong }
    x
  }


  @tailrec def unicodeProductByRecursion( str: String, acc: Long = 1L ): Long = {
    if ( str.isEmpty ) acc else unicodeProductByRecursion( str.tail, acc * str.head.toLong )
  }


  @tailrec def computeUnicode( string: String, acc: Long = 1L ) :Long = string match {
    case s if s.isEmpty => acc
    case s => computeUnicode( s.tail, acc * s.head.toLong )
  }


  val str = "Hello"
  println( s"""ex06: "Hello" unicode product by foldLeft:${unicodeProductByFoldLeft(str)}""" )
  println( s"""ex06: "Hello" unicode product by var loop:${unicodeProductByFor(str)}""" )
  println( s"""ex06: "Hello" unicode product by recursion:${unicodeProductByRecursion(str)}""" )
  println( s"""ex06: "Hello" unicode product by recursion:${computeUnicode(str)}""" )
}
