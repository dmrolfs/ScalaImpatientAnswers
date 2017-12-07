package ch04

import scala.annotation.tailrec

object Exercises01_10 extends App {

  /*
   * 1. Set up a map of prices for a number of gizmos that you covet. Then produce a second map with the same keys and
   * the prices at a 10 percent discount.
   */
  val gizmos = Map( "foo"->3.14, "bar"->4.95, "zed"->1.0 )
  val discounted = gizmos mapValues { _ * (1.0 - 0.1) }
  println( s"""Ex01: gizmos = ${gizmos.mkString("[", ", ", "]")}""" )
  println( s"""Ex01: discounted = ${discounted.mkString("[", ", ", "]")}""" )


  /*
   * 6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and similarly for the other weekdays.
   * Demonstrate that the elements are visited in insertion order.
   */
  val weekdays: Map[String, java.time.DayOfWeek] = {
    java.time.DayOfWeek.values
      .map{ d => d.getDisplayName(java.time.format.TextStyle.FULL, java.util.Locale.US) -> d }
      .toMap
  }
  println( s"""Ex06: weekdays = ${weekdays.mkString("[", ", ", "]")}""")

  /*
   * 8. Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and the largest values
   * in the array.
   */
  def minmax( values: Array[Int] ): (Int, Int) = {
    @tailrec def loop( vs: List[Int], acc: (Int, Int) = (Int.MaxValue, Int.MinValue)): (Int, Int) = vs match {
      case Nil => acc
      case h :: t => {
        val newMin = math.min( acc._1, h )
        val newMax = math.max( acc._2, h )
        loop( t, (newMin, newMax) )
      }
    }

    loop( values.toList )
  }
  val ex8Values = Array( -1, 0, 7, 134, -7 )
  val ex8Empty = Array.empty[Int]
  Seq( ex8Values, ex8Empty ) foreach { vs =>
    println( s"""Ex08: minmax( ${vs.mkString("[", ", ", "]")} ) = ${minmax(vs)}""" )
  }


  /*
   * 9. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values less
   * than v, equal to v, and greater than v.
   */
  def lteqgt( values: Array[Int], v: Int ): (Int, Int, Int) = {
    @tailrec def loop( vs: List[Int], acc: (Int, Int, Int) = (0, 0, 0) ): (Int, Int, Int) = vs match {
      case Nil => acc
      case h :: t if h < v => loop( t, (acc._1 + 1, acc._2, acc._3) )
      case h :: t if h == v => loop( t, (acc._1, acc._2 + 1, acc._3) )
      case h :: t if v < h => loop( t, (acc._1, acc._2, acc._3 + 1) )
    }

    loop( values.toList )
  }
  val ex9ValuesA = Array( -1, 0, 7, 0, 0, 134, -7 )
  val ex9ValuesB = Array( 0, 7, 0, 0, 13 )
  val ex9Empty = Array.empty[Int]
  Seq( ex9ValuesA, ex9ValuesB, ex9Empty ) foreach { vs =>
    println( s"""Ex09: lteqgt( ${vs.mkString("[", ", ", "]")} ) = ${lteqgt(vs, 0)}""" )
  }

  /*
   * 10. What happens when you zip together two strings, such as "Hello".zip("World")? Come up with a plausible use case.
   */
  println( s"""Ex10: "Hello".zip("World") = ${"Hello".zip("World")}""" )
  // useful for combining a pair of collections together for further processing; e.g., to form simpler maps/folds over data
  // A common form of this is to zipWithIndex to associate position in collection with values
}
