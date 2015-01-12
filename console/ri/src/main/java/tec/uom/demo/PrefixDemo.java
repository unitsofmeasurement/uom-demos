package tec.uom.demo;

import static tec.units.ri.util.SIPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.util.SI;

public class PrefixDemo {
	public static void main(String... args) {
		Unit<Mass> kg = KILO(SI.GRAM);
		Quantity<Mass> mass = Quantities.getQuantity(50, KILO(SI.GRAM));
		System.out.println(kg);
	}
}
