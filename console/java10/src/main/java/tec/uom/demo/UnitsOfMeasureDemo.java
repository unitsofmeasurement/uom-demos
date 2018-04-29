package tec.uom.demo;

import static javax.measure.MetricPrefix.NANO;

import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class UnitsOfMeasureDemo {
	public static void main(String... args) {

		// "Seconds" should "be correctly converted to nanoseconds"
		var ns = Units.SECOND.divide(1000000000.0);
		System.out.println(ns);
		var ns2 = NANO(Units.SECOND);
		System.out.println(ns2);
		var fiveSeconds = Quantities.getQuantity(5, Units.SECOND);
		System.out.println(fiveSeconds);
		var inNanos = fiveSeconds.to(ns2);
		// inNanos.getValue.longValue() shouldBe 5000000000L
		System.out.println(inNanos.getValue().longValue());
	}
}
