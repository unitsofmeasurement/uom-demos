valhalla
=========

Project Valhalla Demos

[![Stability: Experimental](https://masterminds.github.io/stability/experimental.svg)](https://masterminds.github.io/stability/experimental.html)

This project explores, how JDK [Project Valhalla](https://jdk.java.net/valhalla/) may work with Unit API.

see [uom-demos#71](https://github.com/unitsofmeasurement/uom-demos/issues/71)

How to Run
-------------------------------------
To run this demo:
- First you need to download and install a Valhalla Early-Access Build from [Project Valhalla](https://jdk.java.net/valhalla/) 
- Because of various Maven plugins not supporting Java 14 out of the box yet, please copy [settings-template.xml](settings-template.xml) to `settings.xml`.
- Change `<java.bin>Path-to-your/jdk-14/bin</java.bin>` in the new file to the `bin` folder of your Java 14 Early-Access installation.

After that you should be able to run the most common Maven goals like `package` or `test` from your IDE or the command line. Using Maven it should not matter which JDK you use to launch it, because the plugins will automatically use the required Early-Access JDK. If you want to run `ValhallaDemo` directly instead of the Maven goal `exec:exec` please add the JDK 14 Early-Access installation as JRE/SDK to your IDE, or adjust your `JAVA_HOME` in the command line.