object Seqs {

  def append[A](a: A, s: Seq[A]): Seq[A] =
     a +: s

  def prepend[A](a: A, s: Seq[A]): Seq[A] =
    s :+ a

  def foo[A](s: Seq[A]): Int =
    s.size

  def main(args: Array[String]): Unit = {
    println(append("a", Stream.continually("b")))
    println(prepend("a", Stream.continually("b")))
    println(prepend("a", List("x", "y", "z")))
    println(prepend("a", (1 to 10).toList))
    println(foo(Stream.continually("x")))
  }
}
