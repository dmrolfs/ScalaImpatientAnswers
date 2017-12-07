package ch02

import scala.annotation.tailrec


object ForLoop04 extends App {
  println( "ex04 - version 1:")
  ( 10 to 0 by -1 ) foreach { println }


  println( "ex04 - version 2:")
  ( 0 to 10 ).reverse foreach { println }


  println( "ex04 - version 3:")
  @tailrec def loopBackFrom( pos: Int ): Unit = pos match {
    case -1 => ()
    case p => {
      println( p )
      loopBackFrom( p - 1 )
    }
  }

  loopBackFrom( 10 )
}
