package tec.uom.demo;

import static tec.units.ri.util.UCUM.ATOMIC_MASS_UNIT;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.units.ri.AbstractQuantity;
import tec.units.ri.quantity.NumberQuantity;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.util.SI;
import tec.units.ri.util.UCUM;

public class UCUMDemo {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit.getSymbol());

		AbstractQuantity<Mass> mass = NumberQuantity.of(10, atomicMassUnit);
		System.out.println(mass);

		AbstractQuantity<Mass> massInKg = mass.to(SI.KILOGRAM);
		System.out.println(massInKg);
		
		Quantity<Mass> pounds = Quantities.getQuantity(25.5, UCUM.POUND);
		Unit<Mass> gramUnit = UCUM.GRAM;

		Quantity grams = pounds.to(gramUnit);
		System.out.println(grams);
	}

}
