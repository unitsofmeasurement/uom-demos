# uom-console-demos-java12
Java 12 Demos for JSR 385

This shows a conflict between `module-info` and **multi-release-JAR** dependencies. 

If an explicit `module-info` like:
```
module tech.uom.demo.java12 {
    requires transitive java.measure;
    requires tech.uom.lib.common;
    requires tech.units.indriya;

    exports tech.uom.demo.java12.format;
    exports tech.uom.demo.java12.function;
}
```
is declared, the build fails:
```
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] ~/git/uom-demos/console/java12/src/main/java/tech/uom/demo/java12/MultiReleaseDemo.java:[7,33] cannot find symbol
  symbol:   class NumberFormatStyle
  location: package tech.units.indriya.format
[ERROR] ~/git/uom-demos/console/java12/src/main/java/tech/uom/demo/java12/MultiReleaseDemo.java:[27,27] cannot find symbol
  symbol:   variable NumberFormatStyle
  location: class tech.uom.demo.java12.MultiReleaseDemo
[ERROR] ~/git/uom-demos/console/java12/src/main/java/tech/uom/demo/java12/MultiReleaseDemo.java:[28,56] cannot find symbol
  symbol:   method getCompactInstance(tech.units.indriya.format.FormatBehavior)
  location: class tech.units.indriya.format.NumberDelimiterQuantityFormat
```

If the `module-info` is removed, it passes.