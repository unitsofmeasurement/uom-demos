package tech.uom.demo

class Repl {
}

fun main(){
    println("Hello World!")
    while(true){
        print("> ")
        val input = readLine()
        val output = process(input)
        println("< You said: $output")
    }
}

fun process(input: String?):String {
    return if(input == null ) {
        ""
    }else{
        parseAndEvaluate(input)
    }
}

fun parseAndEvaluate(input: String):String {

    return "succes"
}
