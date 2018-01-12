package ch08

object Exercise05 extends App {
  class Point( val x: Double, val y: Double ) {
    override def toString: String = s"($x, $y)"
  }

  object Point {
    def apply( x: Double, y: Double ): Point = new Point( x = x, y = y )
  }

  class LabeledPoint( val label: String, x: Double, y: Double ) extends Point( x = x, y = y ) {
    override def toString: String = s"""'${label}':"""+ super.toString
  }

  object LabeledPoint {
    def apply( label: String, x: Double, y: Double ): LabeledPoint = new LabeledPoint( label = label, x = x, y = y )
  }

  val lpt = new LabeledPoint( "Black Thursday", 1929, 230.07 )
  println( "labeled point = " + lpt )
}
