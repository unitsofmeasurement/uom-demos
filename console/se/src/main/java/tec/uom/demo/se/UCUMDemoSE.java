package tec.uom.demo.se;



import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.util.SI;
import static tec.uom.se.util.UCUM.ATOMIC_MASS_UNIT;
public class UCUMDemoSE {

	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;
		System.out.println(atomicMassUnit.getSymbol());

		Quantity<Mass> mass = (Quantity<Mass>) Quantities.getQuantity(10, atomicMassUnit);
		System.out.println(mass);

		Quantity<Mass> massInKg = mass.to(SI.KILOGRAM);
		System.out.println(massInKg);
	}

}
