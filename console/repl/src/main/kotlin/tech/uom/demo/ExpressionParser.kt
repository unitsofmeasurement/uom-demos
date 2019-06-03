package tech.uom.demo

import tech.units.indriya.unit.Units

class ExpressionParser {

    private val unitNames = Units.getInstance().units.map { it.getSymbol() }
    private val valueRegex = """[-+]?[0-9]*(.[0-9]*)?""".toRegex()

    fun parse(tokens: List<Token>): ParseElement {
        // Result := COMPUTATION

        // COMPUTATION = NESTED | OPERATION | QUANTITY
        // NESTED = ( COMPUTATION )
        // OPERATION = COMPUTATION^VALUE | COMPUTATION [+-/*] COMPUTATION

        // VALUE = [-+]?[0-9]*(.[0-9]*)?
        // UNIT = [a-zA-Z)+(^[0-9]+)?
        // QUANTITY = VALUE | VALUE UNIT


        //
        //  2m + ( 4m + 2m )
        // 2m +  4m + 2m

        // 2m ^ 4m

        return parseComputation(tokens)
    }


    private fun parseComputation(left: ParseElement, tokens: List<Token>): ParseElement {
        if (tokens.isEmpty()) return left

        return when (tokens[0].value) {
            in Symbols.OPS -> Operation(
                    value = tokens[0].value,
                    left = left,
                    right = parseComputation(tokens.subList(1, tokens.size))
            )
            "^" -> Operation(
                    value = "^",
                    left = left,
                    right = parseValue(tokens.subList(1, tokens.size))
            )
            else -> throw IllegalStateException("Not sure what to do with remaining: ${tokens.joinToString(separator = " ") {
                it.value
            }}")
        }
    }

    private fun parseComputation(tokens: List<Token>): ParseElement {
        if (tokens[0] == Token("(")) {
            return parseNestedComputation(tokens.subList(1, tokens.size))
        }

        tokens.indexOfFirst { Symbols.OPS.contains(it.value) }.run {
            if (this != -1) {
                return parseComputation(
                        left = parseComputation(tokens.subList(0, this)),
                        tokens = tokens.subList(this, tokens.size)
                )
            }
        }

        tokens.indexOfFirst { it.value == "^" }.run {
            return if (this != -1) {
                parseComputation(
                        left = parseQuantity(tokens.subList(0, this)),
                        tokens = tokens.subList(this, tokens.size)
                )
            } else {
                parseQuantity(tokens)
            }
        }
    }

//    private fun stupidParse(tokens: List<Token>): ParseElement {
//
//
//        val q1 = parseQuantity(tokens[0].value, tokens[1].value)
//
//
//        val q2 = parseQuantity(tokens[3].value, tokens[4].value)
//        val operator = Operation(tokens[2].value, q1, q2)
//
////        if (tokens.size > 2) {
////            if (tokens.size < 5) {
////                throw java.lang.IllegalArgumentException("Righthand side of operation too short")
////            }
////
////        }
//        return operator
//    }

    private fun parseNestedComputation(tokens: List<Token>): ParseElement {
        return tokens.indexOfFirst { it.value == ")" }.run {
            if (this == -1) throw IllegalStateException("Missing closing bracket")
            parseComputation(
                    left = parseComputation(tokens.subList(0, this)),
                    tokens = tokens.subList(this, tokens.size)
            )
        }
    }

    private fun parseValue(tokens: List<Token>): ParseElement {
        if (tokens.size > 1) {
            throw IllegalStateException("To many tokens for value ${tokens.joinToString(separator = " ") {
                it.value
            }}")
        }
        val value = tokens[0].value
        if (valueRegex.matches(value)) {
            return ValueElement(value)
        }
        throw IllegalStateException("Not a legal value $value")
    }

    private fun parseQuantity(tokens: List<Token>): ParseElement {

        if (tokens.size > 2) {
            throw IllegalStateException("To many tokens for quantity ${tokens.joinToString(separator = " ") {
                it.value
            }} (count: ${tokens.size}")
        }

        val value = tokens[0].value
        return if (tokens.size == 2) {
            val unit = tokens[1].value
            if (!unitNames.contains(unit)) {
                throw IllegalStateException("I don't know any unit called $unit")
            }
            QuantityElement(value, unit)
        } else {
            parseValue(tokens)
        }

    }
}


data class Token(val value: String)
