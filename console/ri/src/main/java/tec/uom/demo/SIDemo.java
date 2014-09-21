package tec.uom.demo;

import static tec.units.ri.util.SI.*;

import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.units.ri.AbstractQuantity;
import tec.units.ri.quantity.BaseQuantity;

public class SIDemo {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  UNIFIED_ATOMIC_MASS;
		System.out.println(atomicMassUnit.getSymbol());

		AbstractQuantity<Mass> mass = BaseQuantity.of(10, atomicMassUnit);
		System.out.println(mass);

		AbstractQuantity<Mass> massInKg = mass.to(KILOGRAM);
		System.out.println(massInKg);
	}

}
