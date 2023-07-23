# uom-console-demos-java17
Java 17 Demos for JSR 385

The best way to run this demo is using Maven:
```
mvn exec:java
```

This demo shows a conflict between **JPMS** `module-info` and **multi-release-JAR** dependencies **below Java 16**.

If an explicit `module-info` like:
```
module tech.uom.demo.java17 {
   requires transitive java.measure;
   requires tech.uom.lib.common;
   requires tech.units.indriya;

   exports tech.uom.demo.java17;
   exports tech.uom.demo.java17.format;
   exports tech.uom.demo.java17.types;
}
```
is declared with a Java version **prior to Java 16**, the build **fails**:
```
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.850 s
[INFO] Finished at: 2021-05-10T12:56:18+02:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project uom-console-demos-java12: Compilation failure
[ERROR] ~/git/uom-demos/console/java12/src/main/java/tech/uom/demo/java12/format/QuantityFormatDemo.java:[58,57] method getCompactInstance in class tech.units.indriya.format.NumberDelimiterQuantityFormat cannot be applied to given types;
[ERROR]   required: tech.units.indriya.format.FormatBehavior
[ERROR]   found:    java.text.CompactNumberFormat,tech.units.indriya.format.SimpleUnitFormat
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR]
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
```

Prior to **Java 16** if the `module-info` is removed or renamed (e.g. `module-info.jav_` it passes again.

This is related to https://bugs.openjdk.java.net/browse/JDK-8235229

**NOTE:** Other demos in this module only work in Java 14 or 15 if `--enable-preview` was also used prior to Java 16.
