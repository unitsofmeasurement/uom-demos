package tech.uom.demo.format;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;

import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.SimpleUnitFormat;

public class RoundTripDemo {
    public static void main(String[] args) {
        String unit = "µmol*m^-2*446.2";
        //UnitFormat format = SimpleUnitFormat.getInstance();
        UnitFormat format = EBNFUnitFormat.getInstance();
        Unit<?> parsed = format.parse(unit);
        String formatted = format.format(parsed);
        System.out.println("Formatted version: " + formatted);
        UnitFormat format2 = EBNFUnitFormat.getInstance();
        Unit<?> parsed2 = format2.parse(formatted);
    }
}
