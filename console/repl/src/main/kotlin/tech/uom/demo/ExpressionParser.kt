package tech.uom.demo

import tech.units.indriya.unit.Units

class ExpressionParser {

    private val unitNames = Units.getInstance().units.map { it.getSymbol() }


    fun parse(tokens: List<Token>): ParseElement {
        // Result := COMPUTATION

        // VALUE = [-+]?[0-9]*(.[0-9]*)?
        // UNIT = [a-zA-Z)+(^[0-9]+)?
        // QUANTITY = VALUE | VALUE UNIT
        // COMPUTATION = QUANTITY | ( COMPUTATION ) | COMPUTATION^VALUE | COMPUTATION [+-/*] COMPUTATION


        return parseComputation(tokens)
    }

    private fun parseComputation(tokens: List<Token>): ParseElement {
        return when(tokens[0]){
            Token("(") -> parseNestedComputation(tokens.subList(1,tokens.size))
            else -> stupidParse(tokens)
        }
    }

    private fun stupidParse(tokens: List<Token>): ParseElement {


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

    private fun parseNestedComputation(tokens: List<Token>): ParseElement {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun parseQuantity(value: String, unit: String): QuantityElement {

        if (!unitNames.contains(unit)) {
            throw IllegalArgumentException("I don't know any unit called $unit")
        }
        return QuantityElement(value, unit)
    }
}


data class Token(val value: String)