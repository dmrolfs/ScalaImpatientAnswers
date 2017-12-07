package ch03

import scala.collection.mutable
import scala.util.Random

object Exercises01_06 extends App {
  val a01 = ex01Random( 5 )
  println( s"""ex01: a = ${a01.mkString("[", ", ", "]")}""")
  def ex01Random( n: Int ): Array[Int] = ( 0 to n ).map{ _ => Random.nextInt }.toArray


  var a02 = Array( 1, 2, 3, 4, 5 )
  for ( i <- 0 until a02.size by 2 ) {
    if ( i < a02.size - 1 ) {
      val x = a02(i)
      a02(i) = a02( i + 1 )
      a02( i + 1 ) = x
    }
  }
  println( s"""ex02: a02 after swap: ${a02.mkString("[", ", ", "]")}""" )

  val a03 = Array( 1, 2, 3, 4, 5 )
  val a03Swapped = for {
    i <- 0 until a03.size
  } yield {
    ( i % 2 ) match {
      case 0 if i == a03.size - 1 => a03( i )
      case 0 => a03( i+1 )
      case _ => a03( i - 1 )
    }
  }
  println( s"""ex03: a03Swapped after swap: ${a03Swapped.mkString("[", ", ", "]")}""" )

  val a03SuperStar = Array( 1, 2, 3, 4, 5 ).grouped( 2 ).map { _.reverse }.flatten.toArray
  println( s"""ex03: a03SuperStar after swap: ${a03SuperStar.mkString("[", ", ", "]")}""" )

  def ex04Arrange( as: Array[Int] ): Array[Int] = {
    val posNeg = as.partition{ 0 < _ }
    posNeg._1 ++ posNeg._2
  }
  val ex04_01 = Array( -5, 2, 0, -1, -7, 9, 3, 0 )
  println( s"""ex04: arrange(${ex04_01.mkString("[", ", ", "]")}) = ${ex04Arrange(ex04_01).mkString("[", ", ", "]")}""")

  def ex05Average( values: Array[Double] ): Double = if ( values.isEmpty ) Double.NaN else values.sum / values.size
  val ex05_01 = Array( 3D, 2.0, 7.0 )
  println( s"""ex05: average of ${ex05_01.mkString("[", ", ", "]")} = ${ex05Average(ex05_01)}""")

  def ex06RevSorted_A( values: Array[Int] ): Array[Int] = {
    values.sorted.reverse
  }

  def ex06RevSorted_B( values: Array[Int] )( implicit ordering: Ordering[Int] ): Array[Int] = {
    values.sorted( implicitly[Ordering[Int]].reverse )
  }

  val ex06 = Array( 7, 0, 1, 2, 9, 5 )
  println( s"""ex06: sort_a of ${ex06.mkString("[", ", ", "]")} = ${ex06RevSorted_A(ex06).mkString("[", ", ", "]")}""")
  println( s"""ex06: sort_b of ${ex06.mkString("[", ", ", "]")} = ${ex06RevSorted_B(ex06).mkString("[", ", ", "]")}""")

  val ex06_cd_buf = mutable.ArrayBuffer( 7, 0, 1, 2, 9, 5 )
  def ex06RevSorted_C( values: mutable.ArrayBuffer[Int] ): mutable.ArrayBuffer[Int] = values.sorted.reverse
  println( s"""ex06: sort_c of ArrayBuffer ${ex06_cd_buf.mkString("[", ", ", "]")} = ${ex06RevSorted_C(ex06_cd_buf).mkString("[", ", ", "]")}""")

  def ex06RevSorted_D( values: Seq[Int] ): Seq[Int] = values.sorted.reverse
  val ex06_d1 = Array( 7, 0, 1, 2, 9, 5 )
  println( s"""ex06: sort_d of Array ${ex06_d1.mkString("[", ", ", "]")} = ${ex06RevSorted_D(ex06_d1).mkString("[", ", ", "]")}""")
  println( s"""ex06: sort_d of ArrayBuffer ${ex06_cd_buf.mkString("[", ", ", "]")} = ${ex06RevSorted_D(ex06_cd_buf).mkString("[", ", ", "]")}""")
}
