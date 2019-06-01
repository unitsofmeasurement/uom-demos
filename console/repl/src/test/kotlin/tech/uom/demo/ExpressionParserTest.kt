package tech.uom.demo

import org.hamcrest.core.Is
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.assertThat
import org.junit.Assert.fail
import org.junit.Test

class ExpressionParserTest {

    @Test
    fun `can parse quantity`() {
        val tokens = listOf(Token("3"), Token("l"))

        val parseTree = ExpressionParser().parse(tokens)

        val expectedTree = QuantityElement(value = "3", unit = "l")

        assertThat(parseTree, Is.`is`(expectedTree as ParseElement))
    }


    @Test
    fun `can only parse valid units`() {
        val tokens = listOf(Token("3"), Token("xyz"))


        ExpressionParser().runCatching {
            parse(tokens)
        }.onSuccess {
            fail("Should throw an excecption")
        }.onFailure {
            assertThat(it, instanceOf(IllegalArgumentException::class.java))
        }

    }


}
