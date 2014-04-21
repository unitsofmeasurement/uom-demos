package org.unitsofmeasurement.demo.health;

import static org.unitsofmeasurement.domain.health.Health.BPM;

import org.unitsofmeasurement.domain.health.types.HeartRateAmount;

/**
 * @version 0.1
 * @author Werner
 *
 */
public class HealthDemo {

	public static void main(String[] args) {
		HeartRateAmount amount =  HeartRateAmount.of(Integer.valueOf(60), BPM);
		System.out.println(amount);
	}

}
