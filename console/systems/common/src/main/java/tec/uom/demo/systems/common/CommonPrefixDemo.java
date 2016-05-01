package tec.uom.demo.systems.common;

import static tec.units.ri.unit.MetricPrefix.KILO;
import static tec.units.ri.unit.MetricPrefix.NANO;
import static systems.uom.common.USCustomary.LITER;

import javax.measure.Quantity;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;

import systems.uom.common.IndianPrefix;
import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

public class CommonPrefixDemo {
	public static void main(String... args) {
		Quantity<Length> len = Quantities.getQuantity(10, IndianPrefix.LAKH(Units.METRE));
		System.out.println(len);
		Quantity<Mass> kg = Quantities.getQuantity(50, KILO(Units.GRAM));
		System.out.println(kg);
		
		System.out.println(Quantities.getQuantity(3.3, LITER).toString());
		Quantity<Volume> nl = Quantities.getQuantity(3.3, NANO(LITER));
		System.out.println(nl.toString());
		//UnitFormat format = EBNFUnitFormat.getInstance();
		UnitFormat format = SimpleUnitFormat.getInstance();
		System.out.println(format.format(nl.getUnit()));
	}
}
