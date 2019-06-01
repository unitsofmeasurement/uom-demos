package tech.uom.demo

class ExpressionParser {


    fun parse(tokens: List<Token>): ParseElement {
        return QuantityElement(value="", unit="")
    }

}


data class Token(val value:String)