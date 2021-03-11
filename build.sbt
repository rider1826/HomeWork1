name := "HomeWork-1"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq("org.typelevel" % "cats-core_2.13" % "2.4.2")
libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic-extras",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-literal",
  "io.circe" %% "circe-parser",
  "io.circe" %% "circe-optics",
).map(_ % "0.13.0")