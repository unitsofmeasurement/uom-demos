package tec.uom.demo.se.lambda;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.function.ConversionOperator;
import javax.measure.quantity.Length;

import tec.uom.se.BaseQuantity;
import tec.uom.se.util.SI;
import tec.uom.se.util.US;

public class FunctionalDemo {

	public static void main(String[] args) {
		ConversionOperator<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.to("123");
		System.out.println(converted); // 123
		
		@SuppressWarnings("unchecked")
		ConversionOperator<Unit<Length>, Quantity<Length>> converter2 = (from) -> (Quantity<Length>) BaseQuantity.of(10, SI.METRE);
		Quantity<Length> converted2 = converter2.to(US.INCH);
		System.out.println(converted2); // XYZ
		Quantity<Length> converted3 = converter2.to(US.FOOT);
		System.out.println(converted3);
		//Quantity<Length> conv2 = (from) -> Integer.valueOf(from);
		
		@SuppressWarnings("unchecked")
		Quantity<Length> len = (Quantity<Length>) BaseQuantity.of(10, SI.METRE);
		Quantity<Length> len2 = len.to(US.FOOT);
		System.out.println(len2);
	}
}
