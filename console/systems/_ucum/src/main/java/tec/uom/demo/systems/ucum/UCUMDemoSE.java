package tec.uom.demo.systems.ucum;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Mass;

import systems.uom.ucum.UCUM;
import systems.uom.ucum.format.UCUMFormat;
import systems.uom.ucum.format.UCUMFormat.Variant;
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
		
		UnitFormat format = UCUMFormat.getInstance(Variant.CASE_SENSITIVE);
		Unit<?> unit = format.parse("m/s");
		System.out.println(unit);
		
//		unit = format.parse("m^1*s^-1");
//		System.out.println(unit);
		
		System.out.println(UCUM.PARSEC);
		UnitFormat print = UCUMFormat.getInstance(Variant.PRINT);
		System.out.println(print.format(UCUM.PARSEC));
	}
}
