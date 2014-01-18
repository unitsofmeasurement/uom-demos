package org.unitsofmeasurement.demo.health;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class HealthTest {

	@Test
	@Ignore
	public void test() {
		HeartRateAmount amount =  HeartRateAmount.of(Integer.valueOf(60), Health.BPM);
		assertNotNull(amount);
		assertEquals("b", amount.getUnit().getSymbol());
		assertEquals(60, amount.getValue().intValue());
		
		assertEquals("60 b/min", amount.toString());
	}

}
