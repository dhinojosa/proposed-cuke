ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "proposed-cuke",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.10.0",
      "org.typelevel" %% "cats-effect" % "3.5.4",
      "org.typelevel" %% "cats-parse" % "0.3.9",
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "org.scalameta" %% "munit-scalacheck" % "1.0.0" % Test
    )
  )
