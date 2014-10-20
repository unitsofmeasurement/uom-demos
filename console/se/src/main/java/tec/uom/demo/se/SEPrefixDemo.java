package tec.uom.demo.se;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.util.IndianPrefix;
import tec.uom.se.util.SI;

public class SEPrefixDemo {
	public static void main(String... args) {
		Quantity<Length> len = Quantities.getQuantity(10, IndianPrefix.LAKH(SI.METRE));
		System.out.println(len);
	}
}
