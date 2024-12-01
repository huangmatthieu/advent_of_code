version := "1.0.0"

scalaVersion := "2.12.11"

lazy val root = (project in file("."))
  .settings(
    name := "advent_of_code_2024"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)
