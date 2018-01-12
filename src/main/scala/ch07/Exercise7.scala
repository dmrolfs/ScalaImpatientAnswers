package ch07

import scala.collection.{ Map => SMap }


object Exercise7 extends App {
  import java.util.{ HashMap => JMap }

  val j = javaMap()
  println( "java map: " + j.toString )
  val s = toScala( j )
  println( "scala map: " + s.toString )

  // I'm defining in functions to highlight scoping of imports
  def javaMap(): JMap[String, Int] = {
    val jm = new JMap[String, Int]()
    jm.put( "foo", 3 )
    jm.put( "bar", 5 )
    jm.put( "zed", 13 )
    jm
  }


  def toScala( jm: JMap[String, Int] ): SMap[String, Int] = {
    import scala.collection.JavaConverters._

    val entries = jm.entrySet().asScala map { entry => (entry.getKey, entry.getValue)}
    Map( entries.toSeq:_* )
  }
}
