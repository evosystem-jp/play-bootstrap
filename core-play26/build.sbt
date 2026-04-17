name := """play-bootstrap-core"""

version := "1.6.1-P26"

scalaVersion := "2.12.11"

crossScalaVersions := Seq("2.12.11", "2.11.12")

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"


lazy val root = (project in file(".")).enablePlugins(PlayScala).disablePlugins(PlayFilters, PlayLogback, PlayAkkaHttpServer)

libraryDependencies := libraryDependencies.value.filterNot(m => m.name == "twirl-api" || m.name == "play-server") ++ Seq(
  playCore % "provided"
)

scalariformSettings

//*******************************
// Maven settings
//*******************************

sonatypeSettings

publishMavenStyle := true

organization := "com.adrianhurt"

description := "This is a collection of input helpers and field constructors for Play Framework to render Bootstrap HTML code."

homepage := Some(url("http://playframework.github.io/play-bootstrap"))

licenses := Seq("Apache License" -> url("https://github.com/playframework/play-bootstrap/blob/master/LICENSE"))

startYear := Some(2014)

publishTo := Some("GitHub Package Registry" at "https://maven.pkg.github.com/evosystem-jp/play-bootstrap")

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <scm>
    <url>git@github.com:evosystem-jp/play-bootstrap.git</url>
    <connection>scm:git:git@github.com:evosystem-jp/play-bootstrap.git</connection>
  </scm>
  <developers>
    <developer>
      <id>evosystem-jp</id>
      <name>evosystem-jp</name>
      <url>https://github.com/evosystem-jp</url>
    </developer>
  </developers>
)

credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  sys.env("GITHUB_ACTOR"),
  sys.env("GITHUB_TOKEN")
)
