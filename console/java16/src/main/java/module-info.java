module tech.uom.demo.java16 {
    requires transitive java.measure;
    requires tech.uom.lib.common;
    requires tech.units.indriya;

    exports tech.uom.demo.java16;
    exports tech.uom.demo.java16.format;
    exports tech.uom.demo.java16.function;
    exports tech.uom.demo.java16.rec;
}