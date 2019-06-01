package tech.uom.demo

import org.junit.Assert
import org.junit.Test

class ExpressionTokenizerTest {

	@Test
	fun `can tokenize the input`() {
		var tokekenizedInput = ExpressionTokerizer().tokenize("2 m");
		Assert.assertEquals("Expected 2 tokens", tokekenizedInput.size, 2)
		Assert.assertEquals("Expected 2 as value", tokekenizedInput[0], "2")
		Assert.assertEquals("Expected meter as unit", tokekenizedInput[1], "m")
	}
}