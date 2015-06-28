package tec.uom.demo.systems.common;

import static tec.units.ri.unit.MetricPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import systems.uom.common.IndianPrefix;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

public class CommonPrefixDemo {
	public static void main(String... args) {
		Quantity<Length> len = Quantities.getQuantity(10, IndianPrefix.LAKH(Units.METRE));
		System.out.println(len);
		Quantity<Mass> kg = Quantities.getQuantity(50, KILO(Units.GRAM));
		System.out.println(kg);
	}
}
