# uom-console-demos-java13
Java 13 Demos for JSR 385

The best way to run this demo is using Maven:
```
mvn exec:java
```

Note, you must **build** the demo (e.g. ``mvn clean install``) with **Java 13** or above because **Java 12** (at least to 12.0.1) contains a **bug** which doesn't recognize the correct multi-release-jar version. If you use Java 13 or above, this works. You can however execute the demo with Maven on Java 12. 

This demo further shows a conflict between `module-info` and **multi-release-JAR** dependencies. 

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
[ERROR] ~/git/uom-demos/console/java13/src/main/java/tech/uom/demo/java13/format/UnitFormatDemo.java:[7,33] cannot find symbol
  symbol:   class NumberFormatStyle
  location: package tech.units.indriya.format
[ERROR] ~/git/uom-demos/console/java13/src/main/java/tech/uom/demo/java13/format/UnitFormatDemo.java:[27,27] cannot find symbol
  symbol:   variable NumberFormatStyle
  location: class tech.uom.demo.java13.format.UnitFormatDemo
[ERROR] ~/git/uom-demos/console/java13/src/main/java/tech/uom/demo/java13/format/UnitFormatDemo.java:[28,56] cannot find symbol
  symbol:   method getCompactInstance(tech.units.indriya.format.FormatBehavior)
  location: class tech.units.indriya.format.NumberDelimiterQuantityFormat
```

So far it fails all the way up to **Java 14**. 

If the `module-info` is removed or renamed (e.g. `module-info.jav_` in our demo code), it passes.