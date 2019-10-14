name := """simple-play-app"""
organization := "com.example"

version := "0.1-SNAPSHOT"

Global / cancelable := false

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, JavaAgent)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  guice,
  "io.kamon" %% "kamon-bundle" % "2.0.2",
  "io.kamon" %% "kamon-graphite" % "2.0.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
)

dockerRepository := Some("nemo83")
