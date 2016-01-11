name := """dojo-scala"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"

libraryDependencies += "org.mockito" % "mockito-core" % "1.8.5"

fork in run := true
