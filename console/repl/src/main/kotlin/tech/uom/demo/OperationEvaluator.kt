package tech.uom.demo

import tech.units.indriya.quantity.Quantities
import tech.units.indriya.unit.Units
import javax.measure.Quantity

class OperationEvaluator {

    val units = Units.getInstance().getUnits().map { unit ->
        unit.getSymbol() to unit
    }.toMap()

    fun evaluate(start: ParseElement): Quantity<*>? {
        return when (start) {
            is Operation -> evaluateOperation(start)
            else -> throw IllegalStateException("need to start with an operation")
        }
    }

    private fun evaluateOperation(operation: Operation): Quantity<*>? {

        val q1 = (operation.left as QuantityElement).toQuantity()
        val q2 = (operation.right as QuantityElement).toQuantity()
        q1.multiply(q2)
        return when (operation.value) {
            Symbols.OPS_MULTIPLY -> q1.multiply(q2)
            Symbols.OPS_DIVIDE -> q1.divide(q2)
            else -> null
        }
    }

}

fun QuantityElement.toQuantity() = Quantities.getQuantity("${this.value} ${this.unit}")
//fun QuantityElement.toQuantity2()  =  Quantities.getQuantity( this.value.toInt(), getUnit( this.unit) )
//
//fun getUnit(value:String)= Units.getInstance().getUnits().filter { unit -> unit.getSymbol() == value }.first()
