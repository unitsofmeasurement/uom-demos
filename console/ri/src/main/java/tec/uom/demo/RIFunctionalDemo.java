package tec.uom.demo;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import tec.units.ri.quantity.BaseQuantity;
import tec.units.ri.util.SI;
import tec.units.ri.util.US;

public class RIFunctionalDemo {

	public static void main(String[] args) {
//		ConversionOperator<String, Integer> converter = (from) -> Integer.valueOf(from);
//		Integer converted = converter.to("123");
//		System.out.println(converted); // 123
		
//		ConversionOperator<Unit<Length>, Quantity<Length>> converter2 = (from) -> AbstractQuantity.of(10, SI.METRE);
//		Quantity<Length> converted2 = converter2.to(US.INCH);
//		System.out.println(converted2); // XYZ
//		Quantity<Length> converted3 = converter2.to(US.FOOT);
//		System.out.println(converted3);
		//Quantity<Length> conv2 = (from) -> Integer.valueOf(from);
		
		Quantity<Length> len = BaseQuantity.of(10, SI.METRE);
		Quantity<Length> len2 = len.to(US.FOOT);
		System.out.println(len2);
	}
}
