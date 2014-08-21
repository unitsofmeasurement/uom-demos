package tec.uom.demo.se.lambda;

import javax.measure.function.ConversionOperator;

public class FunctionalDemo {

	public static void main(String[] args) {
		ConversionOperator<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.to("123");
		System.out.println(converted); // 123
	}
}
