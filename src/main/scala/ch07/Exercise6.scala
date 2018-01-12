package ch07

import java.util.{ HashMap => JMap }
import scala.collection.{ Map => SMap }
import scala.collection.JavaConverters._

object Exercise6 extends App {
  val jm = new JMap[String, Int]()
  jm.put( "foo", 3 )
  jm.put( "bar", 5 )
  jm.put( "zed", 13 )
  println( "java map: " + jm.toString )


  val entries = jm.entrySet().asScala map { entry => (entry.getKey, entry.getValue)}
  val sm: SMap[String, Int] = Map( entries.toSeq:_* )
  println( "scala map: " + sm.toString )
}
