package tec.uom.demo.systems.si;

import static tec.uom.se.unit.Units.*;
import static si.uom.SI.*;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Mass;

import si.uom.NonSI;
import si.uom.SI;
import tec.uom.se.AbstractQuantity;
import tec.uom.se.quantity.NumberQuantity;
import tec.uom.se.quantity.Quantities;

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
	
	Quantity<Angle> angle = Quantities.getQuantity(Math.PI, SI.RADIAN);
	System.out.println(angle.to(NonSI.DEGREE_ANGLE));
    }
}
