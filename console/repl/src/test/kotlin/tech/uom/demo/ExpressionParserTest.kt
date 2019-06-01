package tech.uom.demo

import org.hamcrest.core.Is
import org.junit.Test

import org.junit.Assert.*

class ExpressionParserTest {

    @Test
    fun `can parse quantities`() {
        val tokens = listOf(Token("3"), Token("l") )

        val parseTree = ExpressionParser().parse(tokens)

        val expectedTree = QuantityElement(value = "3", unit = "l")

        assertThat(parseTree , Is.`is`(expectedTree as ParseElement))
    }






}
