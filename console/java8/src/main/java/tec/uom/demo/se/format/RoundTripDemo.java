package tec.uom.demo.se.format;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;

import tec.uom.se.format.EBNFUnitFormat;
import tec.uom.se.format.SimpleUnitFormat;

public class RoundTripDemo {
    public static void main(String[] args) {
        String unit = "µmol*m^-2*446.2";
        UnitFormat format = SimpleUnitFormat.getInstance();
        //UnitFormat format = EBNFUnitFormat.getInstance();
        Unit<?> parsed = format.parse(unit);
        String formatted = format.format(parsed);
        System.out.println("Formatted version: " + formatted);
        // FIXME why does EBNFUnitFormat render "µmol·/m²" ?
        UnitFormat format2 = EBNFUnitFormat.getInstance();
        Unit<?> parsed2 = format2.parse(formatted);
    }

}
