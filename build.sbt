
name := "spotify-web-api-scala"
version := "1.0"
scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.2",
  "com.github.kxbmap" %% "configs" % "0.4.4",
  "com.typesafe.play" %% "play-json" % "2.6.7",
  "com.github.kxbmap" %% "configs" % "0.4.4",
  "com.softwaremill.sttp" %% "core" % "1.1.14",
  "com.softwaremill.sttp" %% "okhttp-backend" % "1.1.14",
  "org.scalactic" %% "scalactic" % "3.0.0" % Test,
  "org.scalatest" %% "scalatest" % "3.0.0" % Test
)
