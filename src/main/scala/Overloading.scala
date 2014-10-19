object Overloading {

  def foo(s: String): Unit = ???
  def foo(i: Int): Unit = ???

  def main(args: Array[String]): Unit = {
    println(List("a").map(x => foo(x.length)))
  }
}
