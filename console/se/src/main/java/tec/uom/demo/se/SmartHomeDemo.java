package tec.uom.demo.se;

import javax.measure.Quantity;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.util.SI;

/**
 * 
 * @author Werner
 * @see <a href="http://www.dagego.de/info_waermebedarf.html">Dageto Wärmebedarfsermittlung (DE)</a>
 */
public class SmartHomeDemo {

	public static void main(String[] args) {
		Quantity<Volume> volume = Quantities.getQuantity(1000, SI.LITRE);
		Quantity<Temperature> temperature = Quantities.getQuantity(20, SI.KELVIN);
//		@SuppressWarnings("unchecked")
		Quantity<Energy> energy = (Quantity<Energy>) volume.multiply(temperature);
		Quantity<Energy> result = (energy.multiply(4200)).divide(3600);
		System.out.println(result);
	}

}
