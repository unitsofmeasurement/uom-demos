package tech.uom.demo.basic;

import static javax.measure.MetricPrefix.NANO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Time;

//    import org.scalatest.{FlatSpec, Matchers}

import tech.units.indriya.quantity.NumberQuantity;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

public class UnitsOfMeasureDemo {
	public static void main(String... args) {

//      "Seconds" should "be correctly converted to nanoseconds" in {
		Unit<Time> ns = Units.SECOND.divide(1000000000.0);
		Unit<Time> ns2 = NANO(Units.SECOND);
		Quantity<Time> fiveSeconds = Quantities.getQuantity(5, Units.SECOND);
		System.out.println(fiveSeconds);
		Quantity<Time> inNanos = fiveSeconds.to(ns2);
//        inNanos.getValue.longValue() shouldBe 5000000000L
		System.out.println(inNanos.getValue().longValue());
	}
}
