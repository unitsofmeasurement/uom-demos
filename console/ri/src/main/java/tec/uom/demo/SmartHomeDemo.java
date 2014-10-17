package tec.uom.demo;

import javax.measure.Quantity;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.util.SI;

public class SmartHomeDemo {

	public static void main(String[] args) {
		Quantity<Volume> volume = Quantities.getQuantity(1000, SI.LITRE);
		Quantity<Temperature> temperature = Quantities.getQuantity(20, SI.KELVIN);
		Quantity<Energy> energy = volume.multiply(temperature);
		Quantity<Energy> result = (energy.multiply(4200)).divide(3600);
		System.out.println(result);
	}

}
