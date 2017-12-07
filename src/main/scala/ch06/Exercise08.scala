package ch06


object Color extends Enumeration {
  type Color = Value
  val White = Value( 0xffffff, "White" )
  val Red = Value( 0xff0000, "Red" )
  val Green = Value( 0x00ff00, "Green" )
  val Blue = Value( 0x0000ff, "Blue" )
  val Yellow = Value( 0xffff00, "Yellow" )
  val Fuchsia = Value( 0xff00ff, "Fuchsia" )
  val Cyan = Value( 0x00ffff, "Cyan" )
  val Black = Value( 0x000000, "Black" )
}


object Exercise08 extends App {
  println( s"""Ex08: Colors = ${Color.values.mkString("[", ", ", "]")}""")
  println( s"""Ex08: Color( 0xff00ff ) = ${Color(0xff00ff)}""")
}
