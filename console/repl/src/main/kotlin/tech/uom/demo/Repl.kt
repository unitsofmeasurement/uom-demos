package tech.uom.demo

import java.lang.Exception


fun main() {
    Repl().run()
}

class Repl {
    companion object {
        val tokerizer = ExpressionTokerizer()
        val parser = ExpressionParser()
        val evaluator = OperationEvaluator()
    }

    fun run() {
        while (true) {
            print("> ")
            val input = readLine()
            if ( "exit" == input ){
                break
            }
            try {
                println("< ${process(input)}")
            }catch(e:Exception){
                println("< failure: ${e.localizedMessage}")
            }
        }
    }

    fun process(input: String?): String {
        return if (input == null) {
            ""
        } else {
            parseAndEvaluate(input)
        }
    }

    fun parseAndEvaluate(input: String): String {
        return tokerizer.tokenize(input).run {
            parser.parse(this).run{
                evaluator.evaluate(this)?.toString() ?: "no result"
            }
        }
    }
}