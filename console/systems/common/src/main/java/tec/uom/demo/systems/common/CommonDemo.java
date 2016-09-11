package tec.uom.demo.systems.common;

import javax.measure.Unit;
import javax.measure.spi.SystemOfUnits;

import systems.uom.common.Imperial;

public class CommonDemo {
    public static void main(String... args) {
	SystemOfUnits sou = Imperial.getInstance();
	for (Unit<?> u : sou.getUnits()) {
	    System.out.println(u.getName() + "; " + u.getSymbol() + "; " + u);
	}
    }
}
