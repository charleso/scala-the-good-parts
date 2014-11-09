import scala.io._

object ImplicitConfig {

  def getBytes(s: String)(implicit codec: Codec): Array[Byte] =
    s.getBytes(codec.charSet)

  def main(args: Array[String]): Unit = {
    println(Example1.hello.toList == Example1.hello.toList)
    println(Example1.hello.toList == Example2.hello.toList)
  }

  object Example1 {

    def hello: Array[Byte] =
       getBytes("hello 爨")
  }

  object Example2 {
    implicit val codec2 = scala.io.Codec.ISO8859

    def hello: Array[Byte] =
       getBytes("hello 爨")
  }
}
