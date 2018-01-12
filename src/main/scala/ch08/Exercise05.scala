package Ch08

object Exercies05 extends App {
  class Point( val x: Double, val y: Double )

  class LabeledPoint( val label: String, x: Double, y: Double ) extends Point( x = x, y = y )

  val lpt = new LabeledPoint( "Black Thursday", 1929, 230.07 )
  println( "labeled point = " + lpt )
}
