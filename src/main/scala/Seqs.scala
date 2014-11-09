import scalaz._, Scalaz._

object Seqs {

  def append[A](a: A, s: Seq[A]): Seq[A] =
     a +: s

  def prepend[A](a: A, s: Seq[A]): Seq[A] =
    s :+ a

  def foo[A](s: Seq[A]): Int =
    s.size

  def sayWhatYouMean[F[_]: Functor](f: F[Int]): F[Int] =
    f.map(_ + 1)

  def main(args: Array[String]): Unit = {
    println(append("a", Stream.continually("b")))
    println(prepend("a", Stream.continually("b")))
    println(prepend("a", List("x", "y", "z")))
    println(prepend("a", (1 to 10).toList))
    println(sayWhatYouMean((1 to 10).toList))


    println(foo("a", List("a", "b", "c")))
//    println(foo(Stream.continually("x")))
  }



  def foo[F[_]: Functor](s: F[Int]): F[Int] = {
    s.map(_ + 1)
  }
}
