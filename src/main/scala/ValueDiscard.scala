object ValueDiscard {

  trait IO[A] {
    def map[B](f: A => B): IO[A] = ???
    def flatMap[B](f: A => IO[B]): IO[B] = ???
    def unsafePerformIO(): A
  }
  case class Dictionary(name: String)

  def load(id: String): IO[Dictionary] = ???
  def save(id: String, dictionary: Dictionary): IO[Unit] = ???

  def setName(id: String, name: String) =
    load(id).map(dictionary => save(id, dictionary.copy(name = name)))

  def main(args: Array[String]): Unit = {
    setName("a", "b").unsafePerformIO()
  }
}
