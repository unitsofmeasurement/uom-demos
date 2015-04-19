package tec.uom.demo;

import static tec.units.ri.unit.MetricPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.SI;

public class PrefixDemo {
	public static void main(String... args) {
		Unit<Mass> kg = KILO(SI.GRAM);
		Quantity<Mass> mass = Quantities.getQuantity(50, kg);
		System.out.println(mass);
	}
}
