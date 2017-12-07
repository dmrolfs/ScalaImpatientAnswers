package ch02

object Signum01 extends App {
  def signumByIf( n: Int ): Int = {
    if ( n < 0 ) -1
    else if ( 0 < n ) 1
    else 0
  }

  def signumByMatch( n: Int ): Int = {
    n match {
      case pos if 0 < pos => 1
      case neg if neg < 0 => -1
      case _ => 0
    }
  }

  def signumByNumericCheat[N: Numeric]( n: N ): Int = implicitly[Numeric[N]].signum( n )

  def sig[N]( n: N )( implicit num: Numeric[N] ): Int = num.signum( n )

  def signumByTypeClass[N: Numeric]( n: N ): Int = {
    implicitly[Numeric[N]].toInt( n ) match {
      case pos if 0 < pos => 1
      case neg if neg < 0 => -1
      case _ => 0
    }
  }


  println( s"ex01: signum [13, -7, 0] via if: [${signumByIf(13)}, ${signumByIf(-7)}, ${signumByIf(0)}]" )
  println( s"ex01: signum [13, -7, 0] via match: [${signumByMatch(13)}, ${signumByMatch(-7)}, ${signumByMatch(0)}]" )
  println( s"ex01: signum [13, -7, 0] via numeric cheat: [${signumByNumericCheat(13)}, ${signumByNumericCheat(-7)}, ${signumByNumericCheat(0)}]" )
  println( s"ex01: signum [13, -7, 0] via type class: [${signumByTypeClass(13)}, ${signumByTypeClass(-7)}, ${signumByTypeClass(0)}]" )
}
