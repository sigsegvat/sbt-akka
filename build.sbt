name := "akka-sbt"

version := "1.0"

scalaVersion := "2.11.6"


libraryDependencies +=   "com.typesafe.akka" %% "akka-actor" % "2.3.9"

libraryDependencies +=   "com.typesafe.akka" %% "akka-testkit" % "2.3.9"

libraryDependencies +=   "com.typesafe.akka" %% "akka-remote" % "2.3.9"

libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.3.9"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.13"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % Test