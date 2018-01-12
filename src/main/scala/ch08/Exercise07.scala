package ch08

object Exercise07 extends App {
  import Exercise05.Point
  import Exercise06.Rectangle

  class Square( corner: Point, val width: Double )
  extends Rectangle(
    lowerLeft = corner,
    upperRight = new Point( x = corner.x + width, y = corner.y + width )
  ) {
    def this( width: Double ) = this( corner = Square.origin, width = width )
    def this() = this( width = 0 )

    override def toString: String = s"""Square( corner=${corner} width=${width} center=${centerPoint} )"""
  }

  object Square {
    def apply( corner: Point, width: Double ): Square = new Square(corner, width)
    def fromOrigin( width: Double ): Square = new Square( width = width )
    val empty: Square = new Square( )

    private[ch08] val origin: Point = new Point( 0, 0 )
  }

  println( s"""Square( (1.2, 3.1), 1.7 ) = ${new Square( corner = new Point(1.2, 3.1), width = 1.7 )}""")
  println( s"""Square( (1.2, 3.1), 1.7 ) = ${Square( corner = Point(1.2, 3.1), width = 1.7 )}""")
  println( s"""Square( (1.2, 3.1), 1.7 ) = ${Square.apply( corner = Point(1.2, 3.1), width = 1.7 )}""")

  println( s"""Square( 1.7 ) = ${new Square( width = 1.7 )}""")
  println( s"""Square( 1.7 ) = ${Square.fromOrigin( width = 1.7 )}""")

  println( s"""Square() = ${new Square()}""")
  println( s"""Square() = ${Square.empty}""")
}
