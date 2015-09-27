package tec.uom.demo.systems.ucum;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.Units;
import static systems.uom.ucum.UCUM.ATOMIC_MASS_UNIT;
public class UCUMDemoSE {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit.getSymbol());

		Quantity<Mass> mass = (Quantity<Mass>) Quantities.getQuantity(10, atomicMassUnit);
		System.out.println(mass);

		Quantity<Mass> massInKg = mass.to(Units.KILOGRAM);
		System.out.println(massInKg);
	}
}
