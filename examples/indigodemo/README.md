# indigo-demo

Actually indigo is not a 3d engine, but my purpose wa to check import and usage of scala game math in a project with scala js.

## Getting started with sbt

Type `sbt` into you command line to enter the sbt console, there you will be presented with a welcome screen a list of useful commands. Alternatively, type `sbt welcome`.

There are a number of sbt command aliases ( * ) set up to help you:

1. `sbt runGame` - Run your game via Electron using fast compilation
2. `sbt runGameFull` - Run your game via Electron using full compression
3. `sbt buildGame` - Build your game as a static website using fast compilation
4. `sbt buildGameFull` - Build your game as a static website using full compression

> * Command aliases run a sequence of sbt commands in order, for example, `runGame` is really running `compile`, `fastLinkJS`, and then `indigoRun`.