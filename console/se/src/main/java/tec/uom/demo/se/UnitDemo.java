package tec.uom.demo.se;

import javax.measure.Unit;
import javax.measure.quantity.Speed;

import tec.uom.se.util.*;


public class UnitDemo {

	public static void main(String[] args) {
		Unit<Speed> kmh = SIPrefix.KILO(SI.METRE).divide(UCUM.HOUR).asType(Speed.class);
//		Unit<Speed> kmh2 = SIPrefix.KILO(SI.METRE).multiply(UCUM.HOUR).asType(Speed.class);
		Unit<?> kmh3 = SIPrefix.KILO(SI.METRE).multiply(UCUM.HOUR);
		
		Unit<?> result = kmh.multiply(UCUM.HOUR);
		
		System.out.println(kmh);
//		System.out.println(kmh2);
		System.out.println(kmh3);
		System.out.println(result);
	}

}
