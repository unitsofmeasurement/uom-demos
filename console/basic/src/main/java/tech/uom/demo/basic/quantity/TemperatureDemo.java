package tech.uom.demo.basic.quantity;

import static tech.units.indriya.unit.Units.CELSIUS;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;

import tech.units.indriya.quantity.Quantities;

public class TemperatureDemo {

	public static void main(String[] args) {
		final Quantity<Temperature> t1 = Quantities.getQuantity(2, CELSIUS); 
		final Quantity<Temperature> t2 = Quantities.getQuantity(1, CELSIUS);
		final Quantity<Temperature> t3 = t1.add(t2);
		System.out.println(t3);
	}
}
