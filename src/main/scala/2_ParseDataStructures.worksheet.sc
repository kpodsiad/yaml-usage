import scala.yaml.*
import org.virtuslab.yaml.*

val intSeqYaml =
  """|- 1
     |- 2
     |- 3
     |""".stripMargin
val intSeqJson = "[4,5,6]"

intSeqYaml.as[Seq[Int]].orThrow
intSeqJson.as[Seq[Int]].orThrow

val nullableYamlSeq =
  s"""|- 
      |- !!null
      |- 5
      |""".stripMargin

nullableYamlSeq.as[Seq[Option[Int]]].orThrow

val nullableYamlMap =
  s"""|key: 
      |key1: !!null
      |key2: 5
      |""".stripMargin

nullableYamlMap.as[Map[String, Option[Int]]].orThrow

val nullableYamlAnySeq =
  s"""|- 
      |- !!null
      |- 5
      |- "5"
      |- foo
      |- 5.5
      |""".stripMargin

// lets say we don't know types in colletion
nullableYamlAnySeq.as[Seq[Any]].orThrow
// or even we don't know what we should expect!
nullableYamlAnySeq.as[Any].orThrow
