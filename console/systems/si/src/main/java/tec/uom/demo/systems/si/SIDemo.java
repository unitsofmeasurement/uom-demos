package tec.uom.demo.systems.si;

import static tec.units.ri.unit.Units.*;
import static si.uom.SI.*;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tec.units.ri.AbstractQuantity;
import tec.units.ri.quantity.NumberQuantity;

public class SIDemo {
    public static void main(String[] args) {
	Unit<Mass> atomicMassUnit = UNIFIED_ATOMIC_MASS;
	System.out.println(atomicMassUnit + " (" + atomicMassUnit.getName() + "; " + atomicMassUnit.getSymbol() + ")");

	AbstractQuantity<Mass> mass = NumberQuantity.of(10, atomicMassUnit);
	System.out.println(mass);

	Quantity<Mass> massInKg = mass.to(KILOGRAM);
	System.out.println(massInKg);
	
	System.out.println(WATT_PER_STERADIAN);
	System.out.println(WATT_PER_STERADIAN_PER_SQUARE_METRE);
    }
}
