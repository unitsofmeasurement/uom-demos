package tech.uom.demo

object Symbols {
    const val OPS_MULTIPLY = "*"
    const val OPS_DIVIDE = "/"
    const val OPS_ADD = "+"
    const val OPS_SUBTRACT = "-"
    const val POW = "^"

    val OPS: List<String>

    init {
        OPS = listOf(OPS_MULTIPLY, OPS_DIVIDE, OPS_ADD, OPS_SUBTRACT)
    }

}