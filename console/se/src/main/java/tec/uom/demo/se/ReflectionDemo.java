package tec.uom.demo.se;

import java.lang.reflect.ParameterizedType;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

import tec.uom.se.unit.BaseUnit;

public class ReflectionDemo {
	public static void reflect(final Unit<?> aUnit) {
		// Here I'd like to get the Class-Object 'Length'
		System.out.println(aUnit.getClass().getGenericSuperclass());
		System.out.println(((ParameterizedType) aUnit.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
		System.out.println(aUnit);
		Unit<?> anotherUnit = aUnit.multiply(aUnit).asType(Volume.class);
		System.out.println(anotherUnit.getClass().getGenericSuperclass());
		System.out.println(((ParameterizedType) anotherUnit.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
//		System.out.println(((ParameterizedType) anotherUnit.getClass()
//				.getGenericSuperclass()).getActualTypeArguments().length);
		System.out.println(anotherUnit);
	}

	public static void main(String... args) {
		reflect(new BaseUnit<Length>("m") {

			/**
			 * 
			 */
			private static final long serialVersionUID = -1533169485085040329L;
		});
	}
}
