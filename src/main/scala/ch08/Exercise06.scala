package ch08

object Exercise06 extends App {
  type Point = Exercise05.Point

  abstract class Shape {
    def centerPoint: Point

    override def toString: String = s"${getClass.getSimpleName}( center-point:${centerPoint} )}"
  }

  class Rectangle( lowerLeft: Point, upperRight: Point ) extends Shape {
    override def centerPoint: Point = {
      val cx = ( lowerLeft.x + upperRight.x ) / 2.0
      val cy = ( lowerLeft.y + upperRight.y ) / 2.0
      new Point( x = cx, y = cy )
    }

    override def toString: String = s"Rectangle( lowerLeft=$lowerLeft lowerRight=$upperRight )"
  }

  class Circle( override val centerPoint: Point, radius: Double ) extends Shape {
    override def toString: String = s"Circle( center-point=$centerPoint radius=$radius )"
  }


  val rect = new Rectangle( lowerLeft = new Point(0, 0), upperRight = new Point(4, 3.14) )
  val circle = new Circle( centerPoint = new Point(1.1, 3.14), radius = 1.87)

  println( s"$rect center point is ${rect.centerPoint}" )
  println( s"$circle center point is ${circle.centerPoint}" )
}
