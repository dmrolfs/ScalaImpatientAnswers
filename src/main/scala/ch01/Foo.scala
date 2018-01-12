package ch01

object Foo {
  val scores = Map( "Alice" -> 10, "Bob" -> 3 )

  def proc( winners: Seq[Int] = Seq.empty[Int] ): Unit = ???


  val winners: Seq[Int] = Seq()
  val w = winners :+ scores.find{ _._2 == 3 }.head
}
