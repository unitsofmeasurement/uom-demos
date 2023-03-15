package tech.uom.demo.systems.unicode;

import java.lang.reflect.ParameterizedType;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import systems.uom.unicode.CLDR;
import tech.units.indriya.unit.BaseUnit;
import tech.units.indriya.unit.Units;

public class ReflectionDemo {
	public static void reflect(final Unit<?> aUnit) {
//	public static <U extends Unit<Q>, Q extends Quantity<Q>> void reflect(final U aUnit) {
		// Here I'd like to get the Class-Object 'Length'
		System.out.print("aUnit: ");
//		System.out.println(aUnit.getClass().getGenericInterfaces().length);
		System.out.println(aUnit.getClass().getGenericSuperclass().getClass().getName());
//		System.out.println(aUnit.getClass().getGenericSuperclass().getClass().getGenericInterfaces().length);
		System.out.println(aUnit.getClass().getGenericSuperclass().getClass().getGenericInterfaces()[0]);
		System.out.println(((ParameterizedType) aUnit.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
		System.out.println(aUnit);

//		System.out.print("anotherUnit: ");
//		final Unit<Volume> anotherUnit = aUnit.multiply(aUnit).asType(Volume.class);
//		System.out.println(anotherUnit.getClass().getGenericSuperclass());
//		System.out.println(((ParameterizedType) anotherUnit.getClass()
//				.getGenericSuperclass()).getActualTypeArguments()[0]);
//		// System.out.println(((ParameterizedType) anotherUnit.getClass()
//		// .getGenericSuperclass()).getActualTypeArguments().length);
//		System.out.println(anotherUnit);
	}

	public static void main(String... args) {
		reflect(new BaseUnit<Length>("m"));
//		Unit<Length> len = new BaseUnit<Length>("m");
		var len = Units.METRE;
		reflect(len.multiply(len)); // this works
//		reflect(len.multiply(len).asType(Area.class));  // this won't compile
		
//		for (Unit<?> u : Units.getInstance().getUnits()) {
//			reflect(u);
//		}
		
		for (var u : CLDR.getInstance().getUnits()) {
			reflect(u);
		}
	}
}
