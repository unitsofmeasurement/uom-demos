package tec.uom.demo;

import static tec.uom.ri.util.UCUM.ATOMIC_MASS_UNIT;

import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.uom.ri.AbstractQuantity;
import tec.uom.ri.util.SI;

public class UCUMDemo {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit.getSymbol());

		AbstractQuantity<Mass> mass = AbstractQuantity.of(10, atomicMassUnit);
		System.out.println(mass);

		AbstractQuantity<Mass> massInKg = mass.to(SI.KILOGRAM);
		System.out.println(massInKg);
	}

}
