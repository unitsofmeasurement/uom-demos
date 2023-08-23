package tech.uom.demo.java17;

import static tech.units.indriya.unit.Units.METRE;
import static tech.uom.demo.java17.unit.TemperatureUnit.CELSIUS;

import java.time.Instant;

import javax.measure.quantity.Length;
import javax.measure.quantity.Temperature;

import tech.units.indriya.quantity.Quantities;
import tech.uom.demo.java17.quantity.TemperatureQuantity;
import tech.uom.demo.java17.types.MeasurementRecord;

public class MeasurementDemo {

	public static void main(String[] args) {
		var m1 = new MeasurementRecord<Length>(Quantities.getQuantity(1.8, METRE), Instant.now());
		System.out.println(m1);
		
		var m2 = new MeasurementRecord<Temperature>(new TemperatureQuantity(20, CELSIUS) , Instant.now());
		System.out.println(m2);
	}

}
