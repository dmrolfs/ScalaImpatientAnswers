package ch05

/*
 * 3. Write a class Time with read-only properties hours and minutes and a method before(other: Time): Boolean that
 * checks whether this time comes before the other. A Time object should be constructed as new Time(hrs, min), where
 * hrs is in military time format (between 0 and 23).
 */
class Time03( val hours: Int, val minutes: Int ) {
  def before( other: Time03 ): Boolean = {
    ( this.hours < other.hours ) ||
    ( this.hours == other.hours && this.minutes < other.minutes )
  }
  override def toString: String = hours + ":" + minutes
}

/*
 * 4. Reimplement the Time class from the preceding exercise so that the internal representation is the number of
 * minutes since midnight (between 0 and 24 × 60 – 1). Do not change the public interface. That is, client code should
 * be unaffected by your change.
 */
class Time04( private[ch05] val minutesFromMidnight: Int = 0 ) {
  def this( hours: Int, minutes: Int ) = this( hours * 60 + minutes )
  def hours: Int = minutesFromMidnight / 60 // all Ints so remainder is discarded
  def minutes: Int = minutesFromMidnight % 60
  def before( other: Time04 ): Boolean = this.minutesFromMidnight < other.minutesFromMidnight
  override def toString: String = hours + ":" + minutes
}


object Exercises03_04 extends App {
  val t3_a = new Time03( hours = 15, minutes = 43 )
  val t3_b = new Time03( hours = 6, minutes = 20 )
  println( s"""Ex03: $t3_a before $t3_b = ${t3_a before t3_b}""")
  println( s"""Ex03: $t3_a before $t3_a = ${t3_a before t3_a}""")
  println( s"""Ex03: $t3_b before $t3_a = ${t3_b before t3_a}""")


  val t4_a = new Time04( hours = 15, minutes = 43 )
  val t4_b = new Time04( hours = 6, minutes = 20 )
  println( s"""Ex04: $t4_a before $t4_b = ${t4_a before t4_b}""")
  println( s"""Ex04: $t4_a before $t4_a = ${t4_a before t4_a}""")
  println( s"""Ex04: $t4_b before $t4_a = ${t4_b before t4_a}""")
}