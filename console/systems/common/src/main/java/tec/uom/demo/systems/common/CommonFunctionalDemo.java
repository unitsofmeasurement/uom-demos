package tec.uom.demo.systems.common;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import systems.uom.common.US;
import tec.units.ri.quantity.NumberQuantity;
import tec.units.ri.unit.Units;

public class CommonFunctionalDemo {

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
		
		Quantity<Length> len = NumberQuantity.of(10, Units.METRE);
		Quantity<Length> len2 = len.to(US.FOOT);
		System.out.println(len2);
	}
}
