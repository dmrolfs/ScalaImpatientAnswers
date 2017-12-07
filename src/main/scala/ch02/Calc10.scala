package ch02

object Calc10 extends App {
  println( s"""ex10: 13 ^ 0 = ${calcXn(13, 0)}""")
  println( s"""ex10: 10 ^ -10 = ${calcXn(10, -10)}""")
  println( s"""ex10: 3 ^ 4 = ${calcXn(3, 4)}""")
  println( s"""ex10: 3 ^ 3 = ${calcXn(3, 3)}""")

  def calcXn( x: Double, n: Int ): Double = {
    n match {
      case 0 => 1
      case neg if neg < 0 => 1D / x
      case posEven if posEven % 2 == 0 => {
        val y = math.pow( x, posEven / 2 )
        math.pow( y, 2 )
      }
      case posOdd => x * math.pow( x, posOdd - 1 )
    }
  }
}
