package tech.uom.demo

import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNull.nullValue
import org.junit.Assert.assertThat
import org.junit.Test
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

        assertThat(
                OperationEvaluator().evaluate(inputTree)
                , `is`(expectedResult as Quantity<*>))

    }
}
