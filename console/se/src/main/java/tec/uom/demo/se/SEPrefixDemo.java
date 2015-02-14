package tec.uom.demo.se;

import static tec.uom.se.spi.SIPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.spi.IndianPrefix;
import tec.uom.se.spi.SI;

public class SEPrefixDemo {
	public static void main(String... args) {
		Quantity<Length> len = Quantities.getQuantity(10, IndianPrefix.LAKH(SI.METRE));
		System.out.println(len);
		Quantity<Mass> kg = Quantities.getQuantity(50, KILO(SI.GRAM));
		System.out.println(kg);
	}
}
