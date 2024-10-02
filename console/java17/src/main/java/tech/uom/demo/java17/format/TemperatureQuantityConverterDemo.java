package tech.uom.demo.java17.format;

import static javax.measure.Quantity.Scale.ABSOLUTE;
import static tech.units.indriya.unit.Units.CELSIUS;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Temperature;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.format.EBNFUnitFormat;
import tech.units.indriya.format.SimpleUnitFormat;

public class TemperatureQuantityConverterDemo {
	public static void main(String[] args) {
		//Unit<Temperature> cByTen = CELSIUS.divide(10);
		//var format = EBNFUnitFormat.getInstance();
		var format = SimpleUnitFormat.getInstance();
		Unit<Temperature> cByTen = format.parse("°C/10").asType(Temperature.class);
		Quantity<Temperature> absT = Quantities.getQuantity(0d, CELSIUS, ABSOLUTE);
		Quantity<Temperature> absT2 = Quantities.getQuantity(0d, CELSIUS, ABSOLUTE);
		Quantity<Temperature> absT3 = Quantities.getQuantity(0d, cByTen, ABSOLUTE);
		Quantity<Temperature> sum = absT.add(absT2);
		System.out.println(sum);
		System.out.println(absT3);
		System.out.println(sum.to(cByTen));
	}
}
