package org.unitsofmeasurement.demo.se;

import static org.unitsofmeasurement.impl.util.UCUM.*;

import javax.measure.Unit;
import javax.measure.quantity.Mass;

public class UCUMDemoSE {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit.getSymbol());
	}

}
