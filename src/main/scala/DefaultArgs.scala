import scala.io._

object DefaultArgs {

  def getBytes1(s: String): Array[Byte] =
    s.getBytes
  def getBytes2(s: String, codec: Codec = Codec.ISO8859): Array[Byte] =
    s.getBytes(codec.charSet)

  def main(arg: Array[String]): Unit = {
    println(getBytes1("hello 草").toList == getBytes2("hello 草").toList)
    ()
  }
}
