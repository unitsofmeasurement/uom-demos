package tech.uom.demo.basic.quantity;

import javax.measure.Quantity;

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
	}	
}
