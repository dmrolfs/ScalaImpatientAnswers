package ch03

import scala.collection.mutable

object Exercise08_09 extends App {
  def orig( a: mutable.ArrayBuffer[Int] ): Unit = {
    var first = true
    var n = a.length
    var i = 0
    while ( i < n ) {
      if ( a(i) >= 0 ) i += 1
      else {
        if ( first ) { first = false; i += 1 }
        else { a.remove( i ); n -= 1 }
      }
    }
  }

  val values = Array( 3, 1, 0, -7, -5, 8, -1, 9 )
  val v_orig = values.to[mutable.ArrayBuffer]
  println( s"""ex08: original function on ${v_orig.mkString("[", ", ", "]")} = ${orig(v_orig); v_orig.mkString("[", ", ", "]")}""")

  def ex08( a: mutable.ArrayBuffer[Int] ): Unit = {
    val negatives = a.zipWithIndex.filter{ case (value, _) => value < 0 }
//    val negatives = a.zipWithIndex.filter{ _._1 < 0 }
    negatives.remove(0)
    val discarded = negatives.reverse.map { case (_, index) => a.remove(index) }
//    val discarded = negatives.reverse.map { valueIndex: (Int, Int) => a.remove(valueIndex._2) }
  }

  val v_soln = values.to[mutable.ArrayBuffer]
  println( s"""ex08: solution function on ${v_soln.mkString("[", ", ", "]")} = ${ex08(v_soln); v_soln.mkString("[", ", ", "]")}""")


  def ex09( a: Seq[Int] ): Seq[Int] = {
    val firstNegativePos = a.indexWhere( _ < 0 )
    if ( firstNegativePos < 0 ) a
    else {
      val (head, tail) = a.splitAt( firstNegativePos + 1 )
      head ++ tail.filter{ 0 <= _ }
    }
  }
  println( s"""ex09: solution function on ${values.mkString("[", ", ", "]")} = ${ex09(values).mkString("[", ", ", "]")}""")
}
