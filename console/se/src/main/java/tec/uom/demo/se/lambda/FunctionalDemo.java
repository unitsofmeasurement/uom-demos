package tec.uom.demo.se.lambda;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.function.MeasurementConverter;
import javax.measure.quantity.Length;

import tec.uom.se.quantity.BaseQuantity;
import tec.uom.se.util.SI;
import tec.uom.se.util.US;

public class FunctionalDemo {

	public static void main(String[] args) {
		MeasurementConverter<Length> converter2 = (from) -> (Quantity<Length>) BaseQuantity.of(10, SI.METRE);
		Measurement<Length> converted2 = converter2.to(US.INCH);
		System.out.println(converted2); // XYZ
		Measurement<Length> converted3 = converter2.to(US.FOOT);
		System.out.println(converted3);
		//Quantity<Length> conv2 = (from) -> Integer.valueOf(from);
		
		@SuppressWarnings("unchecked")
		Quantity<Length> len = (Quantity<Length>) BaseQuantity.of(10, SI.METRE);
		Quantity<Length> len2 = len.to(US.FOOT);
		System.out.println(len2);
	}
}
