package ch10

object Exercise04 extends App {
  trait CryptoLogger {
    private val lowerAsciiBound: Int = 'a'
    private val upperAsciiBound: Int = 'z'

    def key: Int = 3
    def encrypt( message: String ): String = {
      val encrypted = for ( c <- message ) yield {
        if ( c < lowerAsciiBound || upperAsciiBound < c ) c
        else {
          ( c + key ) match {
            case e if upperAsciiBound < e => lowerAsciiBound + ( e - upperAsciiBound - 1 )
            case e if e < lowerAsciiBound => upperAsciiBound - ( lowerAsciiBound - e - 1 )
            case e => e
          }
        }
      }

      encrypted.map{ _.toChar }.mkString
    }
  }


  val defaultCrypto = new CryptoLogger { }

  val oneCrypto = new CryptoLogger {
    override val key: Int = 1
  }

  def print( crypto: CryptoLogger )( plaintext: String ): Unit = {
    println( s"crypto[${crypto.key}]:" )
    println( "\t" + plaintext )
    println( "\t" + crypto.encrypt(plaintext) )
  }

  val onePrint = print( oneCrypto )_
  onePrint( "defend the east wall of the castle" )
  onePrint( "abcdefghijklmnopqrstuvwxyz" )

  val threePrint = print( defaultCrypto )_
  threePrint( "defend the east wall of the castle" )
  threePrint( "abcdefghijklmnopqrstuvwxyz" )

  val negThreePrint = print( new CryptoLogger { override val key: Int = -3 } )_
  negThreePrint( "defend the east wall of the castle" )
  negThreePrint( "abcdefghijklmnopqrstuvwxyz" )

}
