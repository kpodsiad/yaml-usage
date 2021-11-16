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



case class Activity(kind: String, distance: Seq[Double]) derives YamlCodec
val activity = Activity("running", Seq(5.37, 4.98, 5.73))
val encoded  = activity.asYaml

