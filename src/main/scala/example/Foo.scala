//package example
//
trait Foo {
  val value: String

  def fn(): Unit = {
    println( "op = " + (value + "World") )
  }
}

object Bar extends App with Foo {
  override val value: String = "Hello "

  fn()
}

