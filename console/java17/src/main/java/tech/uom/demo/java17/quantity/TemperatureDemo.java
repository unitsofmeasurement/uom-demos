package tech.uom.demo.java17.quantity;

import static tech.uom.demo.java17.unit.TemperatureUnit.CELSIUS;

public class TemperatureDemo {

	public static void main(String[] args) {
		var temp1 = new TemperatureQuantity(30, CELSIUS); 
		System.out.println(temp1);
	}

}
