package tech.uom.demo

class ExpressionTokerizer {

    fun tokenize(input: String): List<String> {
        return input.split(" ")
    }
}