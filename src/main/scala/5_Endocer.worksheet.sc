import scala.yaml.*
import org.virtuslab.yaml.*

case class Address(city: String) derives YamlCodec
case class Person(address: Address, ints: Seq[Int]) derives YamlCodec

val data = Person(Address("Anytown"), Seq(1, 2))

val yamlData = data.asYaml

// parse configuration for docker
case class Web(build: String, ports: List[String], volumes: List[String])
    derives YamlCodec
case class Redis(image: String) derives YamlCodec
case class Services(web: Web, redis: Redis) derives YamlCodec
case class Compose(version: String, services: Services) derives YamlCodec

val dockerCompose = Compose(
  version = "3.9",
  services = Services(
    web = Web(
      build = ".",
      ports = List("5000:5000"),
      volumes = List(".:/code", "logvolume01:/var/log")
    ),
    redis = Redis(
      image = "redis:alpine"
    )
  )
)

val dockerComposeYaml = dockerCompose.asYaml
