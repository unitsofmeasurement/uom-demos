# uom-console-demos-java13
Java 13 Demos for JSR 385

The best way to run this demo is using Maven:
```
mvn exec:java
```

This demo shows a conflict between `module-info` and **multi-release-JAR** dependencies. 

If an explicit `module-info` like:
```
module tech.uom.demo.java13 {
   requires transitive java.measure;
   requires tech.uom.lib.common;
   requires tech.units.indriya;

   exports tech.uom.demo.java13.format;
   exports tech.uom.demo.java13.function;
}
```
is declared, the build fails:
```
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] ~/git/uom-demos/console/java13/src/main/java/tech/uom/demo/java13/format/UnitFormatDemo.java:[57,56] cannot find symbol
  symbol:   method getCompactInstance(tech.units.indriya.format.FormatBehavior)
  location: class tech.units.indriya.format.NumberDelimiterQuantityFormat
[INFO] 1 error
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.024 s
[INFO] Finished at: 2021-05-08T23:43:11+02:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project uom-console-demos-java13: Compilation failure
[ERROR] ~/git/uom-demos/console/java13/src/main/java/tech/uom/demo/java13/format/UnitFormatDemo.java:[57,56] cannot find symbol
[ERROR]   symbol:   method getCompactInstance(tech.units.indriya.format.FormatBehavior)
[ERROR]   location: class tech.units.indriya.format.NumberDelimiterQuantityFormat
[ERROR]
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
```

So far this fails all the way up to **Java 14**. 

If the `module-info` is removed or renamed (e.g. `module-info.jav_` in our demo code), it passes.