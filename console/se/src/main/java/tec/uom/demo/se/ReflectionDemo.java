package tec.uom.demo.se;

import java.lang.reflect.ParameterizedType;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

import tec.uom.se.unit.SI;
import tec.uom.se.unit.ucum.UCUM;
import tec.uom.se.unit.BaseUnit;

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
		Unit<Length> len = SI.METRE;
		reflect(len.multiply(len)); // this works under SE 8u20
//		reflect(len.multiply(len).asType(Area.class));  // this won't compile under SE 8u20
		
//		for (Unit<?> u : SI.getInstance().getUnits()) {
//			reflect(u);
//		}
		
		for (Unit<?> u : UCUM.getInstance().getUnits()) {
			reflect(u);
		}
	}
}
