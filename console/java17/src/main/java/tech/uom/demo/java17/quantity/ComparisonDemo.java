package tech.uom.demo.java17.quantity;

import static tech.units.indriya.unit.Units.*;

import java.math.BigDecimal;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Mass;

import tech.units.indriya.function.RationalNumber;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class ComparisonDemo {

	public static void main(String[] args) {
		var result1 = Quantities.getQuantity(0.0, Units.MOLE).add(Quantities.getQuantity(1.1, Units.MOLE));
		var comparative1 = Quantities.getQuantity(1.1, Units.MOLE);
		System.out.println(result1.equals(comparative1));
		
		var result2 = Quantities.getQuantity(0, Units.MOLE).add(Quantities.getQuantity(1, Units.MOLE));
		var comparative2 = Quantities.getQuantity(1, Units.MOLE);
		System.out.println(result2.equals(comparative2));
				
//		BigDecimal b1 = BigDecimal.ZERO.add(BigDecimal.ONE);
//		System.out.println(b1.equals(BigDecimal.ONE));
		//System.out.println("BD=D? " + BigDecimal.ONE.equals(new Double(1)));
		
	    // uses TransformedUnit
	    var w1 = Quantities.getQuantity(12.5, KILOGRAM);

	    // uses BasicUnit
	    @SuppressWarnings("unchecked")
		var w2 = (Quantity<Mass>) Quantities.getQuantity("12,5 kg");

	    System.out.println(w1.equals(w2));
	    //System.out.println(w2.equals(w1));
	    
	    final Unit<Energy> UNIT_WATT_HOUR = Units.WATT.multiply(Units.HOUR).asType(Energy.class);
		var q1 = Quantities.getQuantity(0.0, UNIT_WATT_HOUR).add(Quantities.getQuantity(1.1, UNIT_WATT_HOUR));
		var q2 = Quantities.getQuantity(1.1, UNIT_WATT_HOUR);
		System.out.println(q1.equals(q2));
		
	    var q3 = Quantities.getQuantity(BigDecimal.ZERO, UNIT_WATT_HOUR).add(Quantities.getQuantity(BigDecimal.valueOf(1.1), UNIT_WATT_HOUR));
	    var q4 = Quantities.getQuantity(RationalNumber.of(1.1), UNIT_WATT_HOUR);
		System.out.println(q3.equals(q4));
	}	
}
