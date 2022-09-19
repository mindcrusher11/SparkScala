ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.11.8"

lazy val root = (project in file("."))
  .settings(
    name := "sparkscalabgc",
    idePackagePrefix := Some("org.bgc.uk")
  )

val sparkDependencyScope = "provided"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % Versions.spark,
  "org.apache.spark" %% "spark-sql" % Versions.spark,
  "org.apache.spark" %% "spark-mllib" % Versions.spark,
  "org.apache.spark" %% "spark-streaming" % Versions.spark,
  "org.apache.spark" %% "spark-hive" % Versions.spark,
  /*"com.databricks" %% "spark-csv" % Versions.dataBricksCsv,*/
  "com.typesafe" % "config" % Versions.config,
  "org.scalatest" %% "scalatest" % Versions.scalaTest % Test,
  "org.scalacheck" %% "scalacheck" % Versions.scalaCheck % Test,
  "com.holdenkarau" %% "spark-testing-base" % Versions.sparkTestingBase % Test
)

Test / parallelExecution := false

javaOptions ++= Seq(
  "-Xms512M",
  "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)
