package tec.uom.demo.energy.se;

import static tec.uom.demo.energy.se.DemoUnitSystem.WATTHOUR;

import javax.measure.Quantity;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.quantity.Time;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.MetricPrefix;
import tec.uom.se.unit.Units;

public class EnergyDemo {

	public static void main(String[] args) {
		//System.out.println(DemoUnitSystem.WATTHOUR);
		Quantity<Power> power = Quantities.getQuantity(1000, MetricPrefix.MILLI(Units.WATT));
		Quantity<Time> time = Quantities.getQuantity(15, Units.MINUTE);
		Quantity<Energy> energy = power.multiply(time).asType(Energy.class);
		System.out.println(energy); //Ouput 15000.00 J/s·min -> correct
		System.out.println(energy.to(Units.JOULE)); //Output 900.00 J -> correct
		System.out.println(energy.to(WATTHOUR)); //Output 0.25 m·N -> Expected: 0.25 Wh
		System.out.println(energy.to(MetricPrefix.KILO(Units.JOULE))); //Output 0.90 m·N -> Wrong, expected something like 0.90 kJ or 0.90 kNm
		Quantity<Energy> result = energy.to(MetricPrefix.KILO(WATTHOUR));
		System.out.println(result); //Output 0.00025 m·N -> Wrong, expected 0.00025 kWh
	}
}
