package scala.yaml

import org.virtuslab.yaml.*

implicit class EitherThrowOps[E <: YamlError, T](private val either: Either[E, T]) {
  def orThrow: T =
    either match {
      case Left(e)  => throw new RuntimeException(e.msg)
      case Right(t) => t
    }
}

case class Address(city: String, zipcode: String) derives YamlCodec
case class Person(name: String, address: Address) derives YamlCodec

