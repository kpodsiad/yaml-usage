import scala.yaml.*
import org.virtuslab.yaml.*

val yaml =
  s"""|name: John Wick
       |address:
       |  city: Anywhere
       |  zipcode: 123-45
       |""".stripMargin

val json =
  s"""|{
       |  "name": "John Wick",
       |  "address": {
       |    "city": "Anywhere",
       |    "zipcode": "123-45"
       |  }
       |}
       |""".stripMargin

//decode into well-defined data class
val decoded = yaml.as[Person].orThrow
val decodedJson = json.as[Person].orThrow

//decode unknown data into object
val decodedUntyped = yaml.as[Any].orThrow
val decodedJsonUntyped = json.as[Any].orThrow

// try to decode invalid document
"""|key: value
   |""".stripMargin.as[Person]

case class Square(a: Int, surface: Int)
case class Rectangle(a: Int, b: Int, surface: Int)

import org.virtuslab.yaml.Node.*

val squareDecoder = YamlDecoder[Square] { case ScalarNode(value, _) =>
  val int = value.toInt
  Right(Square(int, int * int))
}
squareDecoder

implicit val settings: LoadSettings = LoadSettings(
  Map(
  Tag[Square] -> squareDecoder,
  )
)
Tag[Square]

"!Square 5".as[Any]

// assertEquals(yaml.as[Any], Right(expected))