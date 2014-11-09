import scalaz._, Scalaz._

object Equals {

  def foo: String =
    "1"

  def bar: Int =
    1

  def main(args: Array[String]): Unit = {
    println(foo == bar)
//    println(Set("a").contains(1))
    println(List("a").contains(1))
    //    println(List("a").exists(1 ===))
    // Doesn't compile
    // println(foo === bar)
  }
}
