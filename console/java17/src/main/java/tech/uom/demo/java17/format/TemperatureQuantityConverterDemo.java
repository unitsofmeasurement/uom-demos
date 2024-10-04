package tech.uom.demo.java17.format;

import static javax.measure.Quantity.Scale.*;
import static tech.units.indriya.unit.Units.CELSIUS;

import java.text.NumberFormat;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Temperature;

import tech.units.indriya.format.NumberDelimiterQuantityFormat;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;

public class TemperatureQuantityConverterDemo {
	public static void main(String[] args) {
		//Unit<Temperature> cByTen = CELSIUS.divide(10);
		var format = SimpleUnitFormat.getInstance();
		Unit<Temperature> cByTen = format.parse("°C/10").asType(Temperature.class);
		Quantity<Temperature> absT = Quantities.getQuantity(0d, CELSIUS, ABSOLUTE);
		Quantity<Temperature> absT2 = Quantities.getQuantity(0d, CELSIUS, ABSOLUTE);
		Quantity<Temperature> relT = Quantities.getQuantity(0d, CELSIUS, RELATIVE);
		Quantity<Temperature> relT2 = Quantities.getQuantity(0d, CELSIUS, RELATIVE);
		Quantity<Temperature> sumAbs = absT.add(absT2);
		Quantity<Temperature> sumRel = relT.add(relT2);
		System.out.println(sumAbs);
		System.out.println(sumRel);		
		System.out.printf("Abs: %s%s", sumAbs.to(cByTen), System.lineSeparator());
		System.out.printf("Rel: %s%s", sumRel.to(cByTen), System.lineSeparator());
		
		var qformat = NumberDelimiterQuantityFormat.getInstance(NumberFormat.getInstance(), format);
        var source =  format.parse("K/10");
        var intermediary = format.parse("K");
		
		var qs = Quantities.getQuantity(10, source, ABSOLUTE);
		System.out.println(qformat.format(qs));
		var qs3 = Quantities.getQuantity(1, intermediary,  ABSOLUTE);
		var qs4 = qs.multiply(qs3);
		System.out.println(qformat.format(qs4));
	}
}
