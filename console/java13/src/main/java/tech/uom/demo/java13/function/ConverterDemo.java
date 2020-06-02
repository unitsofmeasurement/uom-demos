package tech.uom.demo.java13.function;

import tech.units.indriya.function.AbstractConverter;
import tech.units.indriya.function.AddConverter;
import tech.units.indriya.function.MultiplyConverter;
import tech.units.indriya.function.RationalNumber;

public class ConverterDemo {
	public static void main(String[] args) {
	   final AbstractConverter fahrenheitToKelvin = (AbstractConverter) 
	            new AddConverter(RationalNumber.of(27315, 100))
	            .concatenate(MultiplyConverter.ofRational(5, 9))
	            .concatenate(new AddConverter(-32));
	   System.out.println(fahrenheitToKelvin.linearFactor());
	}

}
