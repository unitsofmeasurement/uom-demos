package tech.uom.demo

import org.junit.Test
import tech.units.indriya.quantity.Quantities
import tech.units.indriya.unit.Units.*
import javax.measure.MetricPrefix

class ReplTest {

    @Test
    fun `try a formula`() {

        println(q(3.3, LITRE).toString())
        println(q(3.3, MetricPrefix.NANO(LITRE)).toString())

        println( Quantities  .getQuantity(6, LITRE).divide(2).toString())
        println( Quantities  .getQuantity(6, SQUARE_METRE).divide(q(2,METRE)).toString())
//        println(q(6, Units.METRE).divide(q(2, Units.SECOND)))
    }

}