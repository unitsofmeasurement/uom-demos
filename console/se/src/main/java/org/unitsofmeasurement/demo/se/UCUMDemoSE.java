package org.unitsofmeasurement.demo.se;

import static org.unitsofmeasurement.impl.util.UCUM.ATOMIC_MASS_UNIT;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import org.unitsofmeasurement.impl.AbstractQuantity;
import org.unitsofmeasurement.impl.util.SI;

public class UCUMDemoSE {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit.getSymbol());
		
		AbstractQuantity<Mass> mass = AbstractQuantity.of(10, atomicMassUnit);
		System.out.println(mass);
		
		Quantity<Mass> massInKg = mass.to(SI.KILOGRAM);
		System.out.println(massInKg);
	}

}
