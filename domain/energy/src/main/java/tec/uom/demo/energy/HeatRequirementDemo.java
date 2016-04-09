package tec.uom.demo.energy;

import static tec.units.ri.unit.MetricPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Volume;

import tec.units.ri.format.SimpleUnitFormat;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

/**
 * 
 * @author Werner
 * @see <a href="http://www.dagego.de/info_waermebedarf.html">Dageto Wärmebedarfsermittlung (DE)</a>
 */
public class HeatRequirementDemo {

	public static void main(String[] args) {
		Quantity<Volume> volume = Quantities.getQuantity(1000, Units.LITRE);
		Quantity<Temperature> temperature = Quantities.getQuantity(20, Units.KELVIN);
		@SuppressWarnings("unchecked")
		Quantity<Energy> energy = (Quantity<Energy>) volume.multiply(temperature);
		//Quantity<Energy> energy = volume.multiply(temperature).asType(Energy.class); asType won't work here
		Quantity<Energy> result = (energy.multiply(4200)).divide(3600);
		Unit<Energy> WATTHOUR = result.getUnit();
//		SimpleUnitFormat.getInstance().label(WATTHOUR, "Wh");
//		System.out.println(result);
		SimpleUnitFormat.getInstance().label(KILO(WATTHOUR), "KWh");
		System.out.println(result.to(KILO(WATTHOUR)));
	}
}
