package tech.uom.demo

class ExpressionTokerizer {

    fun tokenize(input: String): List<Token> {
        return input.split(" ").map { Token(it) }
    }
}