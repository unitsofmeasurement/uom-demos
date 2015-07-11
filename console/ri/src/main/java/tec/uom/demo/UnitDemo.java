package tec.uom.demo;

import javax.measure.Unit;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Speed;

import tec.units.ri.unit.MetricPrefix;
import tec.units.ri.unit.Units;

public class UnitDemo {

	public static void main(String[] args) {
		Unit<Speed> kmh = MetricPrefix.KILO(Units.METRE).divide(Units.HOUR).asType(Speed.class);
//		Unit<Velocity> kmh2 = SIPrefix.KILO(SI.METRE).multiply(UCUM.HOUR).asType(Velocity.class);
		Unit<?> kmh3 = MetricPrefix.KILO(Units.METRE).multiply(Units.HOUR);
		
		System.out.println(kmh);
//		System.out.println(kmh2);
		System.out.println(kmh3);
		
//		System.out.println(UCUM.POUND);
//		System.out.println(UCUM.POUND.getSymbol());
//		System.out.println(UCUM.POUND.getName());
		
		System.out.println(Units.KILOGRAM);
		System.out.println(Units.KILOGRAM.getSymbol());
		System.out.println(Units.KILOGRAM.getName());
		
		System.out.println(Units.GRAM);
		System.out.println(Units.GRAM.getSymbol());
		System.out.println(Units.GRAM.getName());
		
		Unit<Dimensionless> d = Units.METRE.asType(Dimensionless.class);
		System.out.println(d);
	}

}
