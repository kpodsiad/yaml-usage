val scala3Version = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "yaml-usage",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.virtuslab" %% "scala-yaml" % "0.0.3+53-e7777f83-SNAPSHOT"
  )
