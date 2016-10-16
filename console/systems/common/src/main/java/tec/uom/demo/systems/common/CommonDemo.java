package tec.uom.demo.systems.common;

import javax.measure.Unit;
import javax.measure.spi.SystemOfUnits;

import systems.uom.common.Imperial;
import systems.uom.common.USCustomary;

public class CommonDemo {
	public static void main(String... args) {
		SystemOfUnits sou = Imperial.getInstance();
		testSoU(sou);
		sou = USCustomary.getInstance();
		testSoU(sou);
	}
	
	private static void testSoU(final SystemOfUnits sou) {
		System.out.println("Testing " + sou.getName());
		for (Unit<?> u : sou.getUnits()) {
			System.out.println(u.getName() + "; " + u.getSymbol() + "; " + u);
		}
	}
}
