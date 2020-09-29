package tech.uom.demo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ExpressionTokenizerTest {

	@Test
	fun `can tokenize the input`() {
		val tokekenizedInput = ExpressionTokerizer().tokenize("2 m");
		Assertions.assertEquals(tokekenizedInput.size, 2, "Expected 2 tokens")
		Assertions.assertEquals(tokekenizedInput[0], Token("2"), "Expected 2 as value")
		Assertions.assertEquals(tokekenizedInput[1], Token("m"), "Expected meter as unit")
	}


}