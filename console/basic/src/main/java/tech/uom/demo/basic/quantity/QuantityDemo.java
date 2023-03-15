package tech.uom.demo.basic.quantity;

import static tech.units.indriya.unit.Units.*;

import java.math.BigDecimal;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Energy;

import tech.units.indriya.function.RationalNumber;
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
		//System.out.println("BD=D? " + BigDecimal.ONE.equals(new Double(1)));
		
	    // uses TransformedUnit
	    Quantity<Mass> w1 = Quantities.getQuantity(12.5, KILOGRAM);

	    // uses BasicUnit
	    @SuppressWarnings("unchecked")
		Quantity<Mass> w2 = (Quantity<Mass>) Quantities.getQuantity("12,5 kg");

	    System.out.println(w1.equals(w2));
	    //System.out.println(w2.equals(w1));
	    	    
	    final Unit<Energy> UNIT_WATT_HOUR = Units.WATT.multiply(Units.HOUR).asType(Energy.class);
	    Quantity<?> q1 = Quantities.getQuantity(0.0, UNIT_WATT_HOUR).add(Quantities.getQuantity(1.1, UNIT_WATT_HOUR));
	    Quantity<?> q2 = Quantities.getQuantity(1.1, UNIT_WATT_HOUR);
		System.out.println(q1.equals(q2));
		
	    Quantity<?> q3 = Quantities.getQuantity(BigDecimal.ZERO, UNIT_WATT_HOUR).add(Quantities.getQuantity(BigDecimal.valueOf(1.1), UNIT_WATT_HOUR));
	    Quantity<?> q4 = Quantities.getQuantity(RationalNumber.of(1.1), UNIT_WATT_HOUR);
		System.out.println(q3.equals(q4));
	}	
}
