package tec.uom.demo.se.lambda;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import tec.uom.se.function.QuantityConverter;
import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.SI;
import tec.uom.se.unit.US;

public class FunctionalDemo {

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		QuantityConverter<Length> converter2 = (from) -> (Quantity<Length>) Quantities.getQuantity(10, SI.METRE);
		Quantity<Length> converted2 = converter2.to(US.INCH);
		System.out.println(converted2); // XYZ
		Quantity<Length> converted3 = converter2.to(US.FOOT);
		System.out.println(converted3);
		//Quantity<Length> conv2 = (from) -> Integer.valueOf(from);
		
		@SuppressWarnings("unchecked")
		Quantity<Length> len = (Quantity<Length>) Quantities.getQuantity(10, SI.METRE);
		Quantity<Length> len2 = len.to(US.FOOT);
		System.out.println(len2);
	}
}
