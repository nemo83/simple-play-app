name := """simple-play-app"""
organization := "com.example"

version := "0.1"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)

scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
)

dockerBaseImage := "openjdk:8-jre-slim"
dockerRepository := Some("nemo83")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
