package tec.uom.demo;

import static tec.units.ri.unit.MetricPrefix.NANO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Time;

//    import org.scalatest.{FlatSpec, Matchers}



    import tec.units.ri.quantity.NumberQuantity;
import tec.units.ri.quantity.Quantities;
import tec.units.ri.unit.Units;

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
