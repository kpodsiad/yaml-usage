import scala.yaml.*
import org.virtuslab.yaml.*

val yaml =
  s"""version: "3.9"
     |services:
     |  web:
     |    build: .
     |    volumes:
     |      - .:/code
     |      - logvolume01:/var/log
     |    ports:
     |      - "5000:5000"
     |  redis:
     |    image: "redis:alpine"
     |""".stripMargin

val node: Node = yaml.asNode.orThrow

val modifiedNode: Node =
  node
    .modify("services")("web")("ports")(0)
    .setValue("6000:6000")
    .modify("services")("redis")("image")
    .setValue("openjdk:11")
    .orThrow

val updatedYaml = modifiedNode.asYaml
