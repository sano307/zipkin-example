lazy val finagleVersion = "6.38.0"

lazy val commonSettings = Seq(
  organization := "sano307",
  version := "0.0.1",
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  scalaVersion := "2.11.7",
  scalacOptions ++= Seq("-deprecation", "-feature", "unchecked"),
  resolvers ++= Seq(
    "Central repo" at "http://central.maven.org/maven2/"
  ),
  assemblyMergeStrategy in assembly := {
    case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
    case "application.conf" => MergeStrategy.concat
    case "unwanted.txt" => MergeStrategy.discard
    case x =>
      val oldStrategy = (assemblyMergeStrategy in assembly).value
      oldStrategy(x)
  },
  test in assembly := {},
  scalafmtOnCompile := true
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "finagle",
    assemblyJarName in assembly := "boot.jar",
    mainClass in assembly := Some("Boot"),
    libraryDependencies ++= {
      Seq(
        // Finagle
        "com.twitter" %% "finagle-http" % finagleVersion
      )
    }
  )
