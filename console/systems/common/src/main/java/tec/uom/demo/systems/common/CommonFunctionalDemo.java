package tec.uom.demo.systems.common;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import systems.uom.common.US;
import tec.units.ri.quantity.NumberQuantity;
import tec.units.ri.unit.Units;

public class CommonFunctionalDemo {

	public static void main(String[] args) {
		Quantity<Length> len = NumberQuantity.of(10, Units.METRE);
		Quantity<Length> len2 = len.to(US.FOOT);
		System.out.println(len2);
	}
}
