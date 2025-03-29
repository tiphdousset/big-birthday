Global / onChangedBuildSource := IgnoreSourceChanges // not working well with webpack devserver

name := "Anniversaire"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.16"

val versions = new {
  val outwatch = "1.0.0"
  val scalaTest = "3.2.19"
  val colibri = "0.8.6"
}

lazy val scalaJsMacrotaskExecutor = Seq(
  // https://github.com/scala-js/scala-js-macrotask-executor
  libraryDependencies += "org.scala-js" %%% "scala-js-macrotask-executor" % "1.1.1",
  Compile / npmDependencies += "setimmediate" -> "1.0.5" // polyfill
)

def readJsDependencies(
    baseDirectory: File,
    field: String
): Seq[(String, String)] = {
  val packageJson =
    ujson.read(IO.read(new File(s"$baseDirectory/package.json")))
  packageJson(field).obj.mapValues(_.str).toSeq
}

lazy val webapp = project
  .enablePlugins(
    ScalaJSPlugin,
    ScalaJSBundlerPlugin,
    BuildInfoPlugin
    // ScalablyTypedConverterPlugin
  )
  .settings(
    scalaJsMacrotaskExecutor,
    // stIgnore ++= List("setimmediate"),
    buildInfoKeys := Seq[BuildInfoKey](
      "email_fanch" -> sys.env("EMAIL_FANCH"),
      "email_tiph" -> sys.env("EMAIL_TIPH"),
      "email_bene" -> sys.env("EMAIL_BENE"),
      "phone_fanch" -> sys.env("PHONE_FANCH"),
      "phone_tiph_de" -> sys.env("PHONE_TIPH_DE"),
      "phone_tiph_fr" -> sys.env("PHONE_TIPH_FR"),
      "phone_bene" -> sys.env("PHONE_BENE")
    ),
    buildInfoPackage := "environment",
    libraryDependencies ++= Seq(
      "io.github.outwatch" %%% "outwatch" % versions.outwatch,
      "org.scalatest" %%% "scalatest" % versions.scalaTest % Test,
      "com.github.cornerman" %%% "colibri" % versions.colibri,
      "com.github.cornerman" %%% "colibri-reactive" % versions.colibri,
      "com.github.cornerman" %%% "colibri-fs2" % versions.colibri,
      "com.github.cornerman" %%% "colibri-router" % versions.colibri
    ),
    Compile / npmDependencies ++= readJsDependencies(
      baseDirectory.value,
      "dependencies"
    ),
    Compile / npmDevDependencies ++= readJsDependencies(
      baseDirectory.value,
      "devDependencies"
    ),
    Compile / npmDependencies += "crypto-js" -> "4.1.1",
    scalacOptions --= Seq(
      "-Xfatal-warnings"
    ), // overwrite option from https://github.com/DavidGregory084/sbt-tpolecat

    useYarn := true, // Makes scalajs-bundler use yarn instead of npm
    yarnExtraArgs += "--prefer-offline",
    scalaJSLinkerConfig ~= (_.withModuleKind(
      ModuleKind.CommonJSModule
    )), // configure Scala.js to emit a JavaScript module instead of a top-level script
    scalaJSUseMainModuleInitializer := true, // On Startup, call the main function
    webpackDevServerPort := sys.env
      .get("FRONTEND_PORT")
      .flatMap(port => scala.util.Try(port.toInt).toOption)
      .getOrElse(12345),
    webpackDevServerExtraArgs := Seq("--color"),
    webpack / version := "5.75.0",
    webpackCliVersion := "5.0.0",
    startWebpackDevServer / version := "4.11.1",
    webpackDevServerExtraArgs := Seq("--color"),
    fullOptJS / webpackEmitSourceMaps := true,
    fastOptJS / webpackBundlingMode := BundlingMode.LibraryOnly(),
    fastOptJS / webpackConfigFile := Some(
      baseDirectory.value / "webpack.config.dev.js"
    ),
    fullOptJS / webpackConfigFile := Some(
      baseDirectory.value / "webpack.config.prod.js"
    ),
    Test / requireJsDomEnv := true
  )

addCommandAlias("prod", "fullOptJS/webpack")
addCommandAlias("dev", "devInit; devWatchAll; devDestroy")
addCommandAlias("devInit", "; webapp/fastOptJS/startWebpackDevServer")
addCommandAlias("devWatchAll", "~; webapp/fastOptJS/webpack")
addCommandAlias("devDestroy", "webapp/fastOptJS/stopWebpackDevServer")
