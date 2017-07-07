package tec.uom.demo.systems.ucum;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Frequency;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.spi.ServiceProvider;

import systems.uom.ucum.UCUM;
import systems.uom.ucum.format.UCUMFormat;
import systems.uom.ucum.format.UCUMFormat.Variant;
import tec.uom.se.format.EBNFUnitFormat;
import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.MetricPrefix;
import tec.uom.se.unit.Units;
import static systems.uom.ucum.UCUM.ATOMIC_MASS_UNIT;
import static tec.uom.se.unit.MetricPrefix.KILO;

public class UCUMFormatDemo {

    public static void main(String[] args) {
	final UnitFormat unitFormat = ServiceProvider.current().getUnitFormatService().getUnitFormat("CI");
	final Unit<Volume> microliter = MetricPrefix.MICRO(Units.LITRE);
	System.out.println(unitFormat.format(microliter)); // prints "nst"!
	UnitConverter conv = microliter.getConverterTo(UCUM.STERE);
	System.out.println(conv);
	UnitConverter conv2 = microliter.getConverterTo(Units.CUBIC_METRE);
	System.out.println(conv);
	
	final Unit<?> microliter2 = unitFormat.parse("uL");
	System.out.println(unitFormat.format(microliter2));
	
	final UnitFormat unitFormat2 = ServiceProvider.current().getUnitFormatService().getUnitFormat("CS");
	final Unit<?> microliter3 = unitFormat2.parse("ul");
	System.out.println(unitFormat2.format(microliter3));
	
	final Unit<?> invKelvin = unitFormat.parse("1/K");
	System.out.println(invKelvin);
    }
}
