package ch06

object Conversions01 {
  def inchesToCentimeters( inches: Double ): Double = inches * 2.54
  def gallonsToLiters( gallons: Double ): Double = gallons * 3.78541
  def milesToKilometers( miles: Double ): Double = miles * 1.60934
}



abstract class UnitConversion extends (Double => Double) {
  override def apply( value: Double ): Double = value * factor
  protected val factor: Double
}

object InchesToCentimeters extends UnitConversion {
  override protected val factor: Double = 2.54
}

object GallonsToLiters extends UnitConversion {
  override protected val factor: Double = 3.78541
}

object MilesToKilometers extends UnitConversion {
  override protected val factor: Double = 1.60934
}


object Exercises01_02 extends App {
  println( s"""Ex01: 12.5in = ${Conversions01.inchesToCentimeters(12.5)}cm""")
  println( s"""Ex01: 17.3gal = ${Conversions01.gallonsToLiters(17.3)}l""")
  println( s"""Ex01: 60mi = ${Conversions01.milesToKilometers(60.0)}km""")

InchesToCentimeters.apply( 12.5 )
  println( s"""Ex02: 12.5in = ${InchesToCentimeters(12.5)}cm""")
  println( s"""Ex02: 17.3gal = ${GallonsToLiters(17.3)}l""")
  println( s"""Ex02: 60mi = ${MilesToKilometers(60.0)}km""")
}