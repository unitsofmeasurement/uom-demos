package tec.uom.demo.energy;

import static tec.units.ri.unit.MetricPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
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

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Quantity<Volume> volume = Quantities.getQuantity(1000, Units.LITRE);
		Quantity<Temperature> temperature = Quantities.getQuantity(20, Units.KELVIN);
		Quantity<Energy> energy = (Quantity<Energy>) volume.multiply(temperature);
		//Quantity<Energy> energy = volume.multiply(temperature).asType(Energy.class); asType won't work here
		Quantity<Energy> result = (energy.multiply(4200)).divide(3600);
		Unit<Energy> WATTHOUR = result.getUnit();
//		SimpleUnitFormat.getInstance().label(WATTHOUR, "Wh");
//		System.out.println(result);
		Quantity<Energy> kwH = result.to(KILO(WATTHOUR));
		SimpleUnitFormat.getInstance().label(KILO(WATTHOUR), "KWh");
		System.out.println(kwH);
		Quantity<Power> kiloWatt = Quantities.getQuantity(9.5, KILO(Units.WATT));
		Quantity<Time> time =  (Quantity<Time>) kwH.divide(kiloWatt);
		SimpleUnitFormat.getInstance().label(time.getUnit(), "h");
		System.out.println(time);
	}
}
