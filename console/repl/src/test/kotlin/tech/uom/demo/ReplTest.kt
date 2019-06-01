package tech.uom.demo

import org.junit.Test
import tech.units.indriya.quantity.Quantities
import tech.units.indriya.unit.Units
import tech.units.indriya.unit.Units.LITRE
import javax.measure.MetricPrefix

class ReplTest {

    @Test
    fun `try a formula`() {

        println(q(3.3, Units.LITRE).toString())
        println(q(3.3, MetricPrefix.NANO(LITRE)).toString())

        println( Quantities  .getQuantity(6, Units.LITRE).divide(2).toString())
//        println(q(6, Units.METRE).divide(q(2, Units.SECOND)))
    }

}