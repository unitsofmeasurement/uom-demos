package tech.uom.demo

class ExpressionParser {


    fun parse(tokens: List<Token>): ParseElement {
        return QuantityElement(value=tokens[0].value, unit=tokens[1].value)
    }

}


data class Token(val value:String)