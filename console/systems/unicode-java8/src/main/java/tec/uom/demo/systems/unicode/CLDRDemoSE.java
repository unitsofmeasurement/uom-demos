package tec.uom.demo.systems.unicode;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.uom.se.quantity.Quantities;
import static systems.uom.unicode.CLDR.*;

public class CLDRDemoSE {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  CARAT;
		System.out.println(atomicMassUnit.getSymbol());

		Quantity<Mass> mass = (Quantity<Mass>) Quantities.getQuantity(10, atomicMassUnit);
		System.out.println(mass);

		Quantity<Mass> massInKg = mass.to(KILOGRAM);
		System.out.println(massInKg);
		
//		UnitFormat format = UCUMFormat.getInstance(Variant.CASE_SENSITIVE);
//		Unit<?> unit = format.parse("m/s");
//		System.out.println(unit);
		
//		unit = format.parse("m^1*s^-1");
//		System.out.println(unit);
		
		Quantity<Length> cm = Quantities.getQuantity(10, CENTIMETER);
		System.out.println(cm);
		
		Quantity<Length> ft = cm.to(FOOT);
		System.out.println(ft);
	}
}
