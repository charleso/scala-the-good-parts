import scala.concurrent._
// import scala.concurrent.ExecutionContext.Implicits.global

object ImplicitConfig2 {
  def main(args: Array[String]): Unit = {
    import Pool.tc
    val r = Future { println("Success!") }
    println(r)
  }

  object Pool {
    implicit val tc: ExecutionContext = ExecutionContext.fromExecutor(java.util.concurrent.Executors.newCachedThreadPool())
  }
}

object ImplicitConfig3 {
  def main(args: Array[String]): Unit = {
    val r = Pool.withEC { implicit ec =>
      Future { println("Success!") }
    }
    println(r)
  }

  object Pool {
    def withEC[A](f: ExecutionContext => A): A = {
      val pool = java.util.concurrent.Executors.newCachedThreadPool
      val result = f(ExecutionContext.fromExecutor(pool))
      pool.shutdown()
      result
    }
  }
}