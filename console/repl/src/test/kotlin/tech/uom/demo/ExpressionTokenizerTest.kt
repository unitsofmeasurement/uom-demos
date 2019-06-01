package tech.uom.demo

import org.junit.Assert
import org.junit.Test

class ExpressionTokenizerTest {

	@Test
	fun `can tokenize the input`() {
		val tokekenizedInput = ExpressionTokerizer().tokenize("2 m");
		Assert.assertEquals("Expected 2 tokens", tokekenizedInput.size, 2)
		Assert.assertEquals("Expected 2 as value", tokekenizedInput[0], Token("2"))
		Assert.assertEquals("Expected meter as unit", tokekenizedInput[1], Token("m"))
	}
}