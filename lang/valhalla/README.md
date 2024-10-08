valhalla
=========

Project Valhalla Demos

[![Stability: Experimental](https://masterminds.github.io/stability/experimental.svg)](https://masterminds.github.io/stability/experimental.html)

This project explores, how JDK [Project Valhalla](https://jdk.java.net/valhalla/) may work with Unit API.

see [uom-demos#113](https://github.com/unitsofmeasurement/uom-demos/issues/113)

How to Run
-------------------------------------
To run this demo:
- First you need to download and install a Valhalla Early-Access Build from [Project Valhalla](https://jdk.java.net/valhalla/) 
- Because some Maven plugins don't support the Valhalla Early-Access Build out of the box yet, please copy [settings-template.xml](settings-template.xml) to `settings.xml`.
- Change `<java.bin>Path-to-your/valhalla-early-access/bin</java.bin>` in the new file to the `bin` folder of your Valhalla Early-Access installation.

After that you should be able to run the most common Maven goals like `package` or `test` from your IDE or the command line. Using Maven it should not matter which JDK you use to launch it, because the plugins will automatically use the required Early-Access JDK. If you want to run the `valhalla` demo directly instead of the Maven goal `exec:java` please add the Valhalla Early-Access installation as JRE/SDK to your IDE, or adjust your `JAVA_HOME` in the command line.