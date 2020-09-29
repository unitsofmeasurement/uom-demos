package tech.uom.demo

import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNull.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import tech.units.indriya.unit.Units
import javax.measure.Quantity

class OperationEvaluatorTest {


    @Test
    fun `cannot add (yet)`() {

        val inputTree = Operation(
                value = "+",
                left = QuantityElement(value = "3", unit = "m"),
                right = QuantityElement(value = "4", unit = "m")
        )

        assertThat(
                OperationEvaluator().evaluate(inputTree)
                , nullValue())

    }

    @Test
    fun `can multiply`() {

        val inputTree = Operation(
                value = "*",
                left = QuantityElement(value = "3", unit = "m"),
                right = QuantityElement(value = "4", unit = "m")
        )

        val expectedResult = q(12, Units.SQUARE_METRE)

        val result = OperationEvaluator().evaluate(inputTree)
        assertThat(
                result
                , `is`(expectedResult as Quantity<*>))

    }

    @Disabled("Rational numbers are not properly implemented it seems")
    @Test
    fun `can divide`() {
        val inputTree = Operation(
                value = "/",
                left = QuantityElement(value = "12", unit = "m^2"),
                right = QuantityElement(value = "3", unit = "m")
        )

        val expectedResult = q(4, Units.METRE)

        val result = OperationEvaluator().evaluate(inputTree)
        assertThat(
                result
                , `is`(expectedResult as Quantity<*>))

    }
}
