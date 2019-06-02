package tech.uom.demo

import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.assertThat
import org.junit.Assert.fail
import org.junit.Ignore
import org.junit.Test

class ExpressionParserTest {

    @Test
    @Ignore
    fun `can parse quantity`() {
        val tokens = listOf(
                Token("3"),
                Token("l"))

        val parseTree = ExpressionParser().parse(tokens)

        val expectedTree = QuantityElement(value = "3", unit = "l")

        assertThat(parseTree, `is`(expectedTree as ParseElement))
    }


    @Test
    fun `can only parse valid units`() {
        val tokens = listOf(Token("3"), Token("xyz"))

        ExpressionParser().runCatching {
            parse(tokens)
        }.onSuccess {
            fail("Should throw an excecption")
        }.onFailure {
            assertThat(it, instanceOf(IllegalStateException::class.java))
        }

    }


    @Test
    fun `can parse operation between quantities`() {
        val tokens = listOf(
                Token("3"), Token("l"),
                Token("+"),
                Token("4"), Token("m")
        )

        val parseTree = ExpressionParser().parse(tokens)

        val expectedTree = Operation(
                value = "+",
                left = QuantityElement(value = "3", unit = "l"),
                right = QuantityElement(value = "4", unit = "m")
        )

        assertThat(parseTree, `is`(expectedTree as ParseElement))
    }

}
