/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package tech.uom.demo.health;

import static org.junit.Assert.*;
import static tech.uom.domain.health.unit.Health.BPM;

import org.junit.Test;

import tech.uom.domain.health.types.HeartRateAmount;

public class HealthTest {

	@Test
	public void test() {
		HeartRateAmount amount = HeartRateAmount.of(Integer.valueOf(60), BPM);
		assertNotNull(amount);
		assertEquals("b", amount.getUnit().getSymbol());
		assertEquals(60, amount.getValue().intValue());
		
		assertEquals("60 b/min", amount.toString());
	}

}
