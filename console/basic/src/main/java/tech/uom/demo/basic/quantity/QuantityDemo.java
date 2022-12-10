package tech.uom.demo.basic.quantity;

import static tech.units.indriya.unit.Units.*;

import javax.measure.MetricPrefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class QuantityDemo {

	public static void main(String[] args) {
		Quantity<?> result1 = Quantities.getQuantity(0.0, Units.MOLE).add(Quantities.getQuantity(1.1, Units.MOLE));
		Quantity<?> comparative1 = Quantities.getQuantity(1.1, Units.MOLE);
		System.out.println(result1.equals(comparative1));
		
		Quantity<?> result2 = Quantities.getQuantity(0, Units.MOLE).add(Quantities.getQuantity(1, Units.MOLE));
		Quantity<?> comparative2 = Quantities.getQuantity(1, Units.MOLE);
		System.out.println(result2.equals(comparative2));
				
//		BigDecimal b1 = BigDecimal.ZERO.add(BigDecimal.ONE);
//		System.out.println(b1.equals(BigDecimal.ONE));
		
	    // uses TransformedUnit
	    Quantity<Mass> w1 = Quantities.getQuantity(12.5, KILOGRAM);

	    // uses BasicUnit
	    Quantity<Mass> w2 = (Quantity<Mass>) Quantities.getQuantity("12,5 kg");

	    System.out.println(w1.equals(w2));
	    //System.out.println(w2.equals(w1));
	    
	    Unit unit = Units.WATT.multiply(Units.HOUR);
		Quantity q1 = Quantities.getQuantity(0.0, unit).add(Quantities.getQuantity(1.1, unit));
		Quantity q2 = Quantities.getQuantity(1.1, unit);
		System.out.println(q1.equals(q2));
	}	
}
