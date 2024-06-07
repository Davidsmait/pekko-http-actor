// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

resolvers += "Apache Snapshots" at "https://repository.apache.org/content/repositories/snapshots/"

lazy val root = (project in file(".")).settings(
  inThisBuild(List(organization := "com.davidsan", scalaVersion := "2.13.12")),
  name := "My Pekko HTTP Project",
  libraryDependencies ++= {
    val pekkoV     = "1.0.2"
    val pekkoHttpV = "1.0.1"
    val logbackV   = "1.5.6"
    val scalatestV = "3.2.18"
    Seq(
      "org.apache.pekko" %% "pekko-http"                % pekkoHttpV,
      "org.apache.pekko" %% "pekko-http-spray-json"     % pekkoHttpV,
      "org.apache.pekko" %% "pekko-actor-typed"         % pekkoV,
      "org.apache.pekko" %% "pekko-stream"              % pekkoV,
      "ch.qos.logback"    % "logback-classic"           % logbackV,
      "org.apache.pekko" %% "pekko-slf4j"               % pekkoV,
      "org.apache.pekko" %% "pekko-http-testkit"        % pekkoHttpV % Test,
      "org.apache.pekko" %% "pekko-actor-testkit-typed" % pekkoV     % Test,
      "org.scalatest"    %% "scalatest"                 % scalatestV % Test
    )
  }
)
