import scala.yaml.*
import org.virtuslab.yaml.*

val alias1 =
  s"""|- &mark
      |  name: Mark McGwire
      |  hr:   65
      |- *mark
      |- [*mark, *mark]
      |""".stripMargin

alias1.as[Any].orThrow


val alias2 =
  s"""|key: &v1 value1
      |key2: &v2 value2
      |values: [*v1, *v2]
      |*v1 : *v2
      |""".stripMargin

alias2.as[Any].orThrow