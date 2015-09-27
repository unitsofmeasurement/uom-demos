package tec.uom.demo.systems.iso80k;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import systems.uom.quantity.Information;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;
import static systems.uom.iso80k.ISO80000.*;

public class ISO80000Demo {
	public static void main(String[] args) {
		Unit<Mass> atomicMassUnit =  ATOMIC_MASS_UNIT;

		Quantity<Mass> mass =  Quantities.getQuantity(10, atomicMassUnit);
		System.out.println(mass);

		Quantity<Mass> massInKg = mass.to(Units.KILOGRAM);
		System.out.println(massInKg);
		
		Quantity<Mass> carat = Quantities.getQuantity(100, CARAT_METRIC);
		System.out.println(carat);
		Quantity<Mass> caratsInKg = carat.to(Units.KILOGRAM);
		System.out.println(caratsInKg);
		
		Quantity<Information> bit = Quantities.getQuantity(20, BIT);
		System.out.println(bit);
		Quantity<Information> bytes = bit.to(BYTE);
		System.out.println(bytes);
	}

}
