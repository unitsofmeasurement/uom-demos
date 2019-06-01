package tech.uom.demo

import tech.units.indriya.unit.Units

class ExpressionParser {

    private val unitNames = Units.getInstance().units.map { it.getSymbol() }


    fun parse(tokens: List<Token>): ParseElement {
        val q1 = parseQuantity(tokens[0].value, tokens[1].value)
        val q2 = parseQuantity(tokens[3].value, tokens[4].value)
        val operator = Operation(tokens[2].value, q1, q2)

//        if (tokens.size > 2) {
//            if (tokens.size < 5) {
//                throw java.lang.IllegalArgumentException("Righthand side of operation too short")
//            }
//
//        }
        return operator
    }

    private fun parseQuantity(value: String, unit: String): QuantityElement {

        if (!unitNames.contains(unit)) {
            throw IllegalArgumentException("I don't know any unit called $unit")
        }
        return QuantityElement(value, unit)
    }
}


data class Token(val value: String)