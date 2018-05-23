
name := "spotify-web-api-scala"
version := "1.0"
scalaVersion := "2.12.5"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.2",
  "com.github.kxbmap" %% "configs" % "0.4.4",
  //"com.typesafe.play" %% "play-json" % "2.6.7",
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.json4s" %% "json4s-native" % "3.5.3",
  "org.json4s" %% "json4s-jackson" % "3.5.3",
  "com.github.kxbmap" %% "configs" % "0.4.4",
  "org.scalactic" %% "scalactic" % "3.0.0" % Test,
  "org.scalatest" %% "scalatest" % "3.0.0" % Test
)
