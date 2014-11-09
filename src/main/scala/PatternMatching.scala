object PatternMatching {

  sealed trait Encoding
  case object StringEncoding extends Encoding
  case object IntEncoding extends Encoding
  case object DateEncoding extends Encoding

  def asString(encoding: Encoding): String = encoding match {
    case _: StringEncoding.type  => "string"
    case _ => "int"
  }

  def asString2(encoding: Encoding): String = encoding match {
    case StringEncoding if "a" == "b"  => "string"
  }

  def main(args: Array[String]): Unit = {
    println(asString(StringEncoding))
  }
}
