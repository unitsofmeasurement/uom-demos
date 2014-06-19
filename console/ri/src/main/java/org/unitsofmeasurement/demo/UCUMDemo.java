package org.unitsofmeasurement.demo;

import static org.unitsofmeasurement.ri.util.UCUM.*;

import javax.measure.Unit;
import javax.measure.quantity.Mass;

import org.unitsofmeasurement.ri.util.SI;
import org.unitsofmeasurement.ri.AbstractQuantity;

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
