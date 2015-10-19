package tec.uom.demo.energy;

import static tec.uom.demo.energy.DemoUnitSystem.WATTHOUR;

import javax.measure.Quantity;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.quantity.Time;

import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.MetricPrefix;
import tec.units.ri.unit.Units;

public class EnergyDemo {

	public static void main(String[] args) {
		//System.out.println(DemoUnitSystem.WATTHOUR);
		Quantity<Power> power = Quantities.getQuantity(1000, MetricPrefix.MILLI(Units.WATT));
		Quantity<Time> time = Quantities.getQuantity(15, Units.MINUTE);
		Quantity<Energy> energy = power.multiply(time).asType(Energy.class);
		System.out.println(energy); //Ouput 15000.00 J/s·min -> correct
		System.out.println(energy.to(Units.JOULE)); //Output 900.00 J -> correct
		System.out.println(energy.to(WATTHOUR)); //Output expected: 0.25 Wh
		System.out.println(energy.to(MetricPrefix.KILO(Units.JOULE))); //Output expected something like 0.90 kJ or 0.90 kNm
		Quantity<Energy> result = energy.to(MetricPrefix.KILO(WATTHOUR));
		System.out.println(result); //Output expected 0.00025 kWh
	}
}
