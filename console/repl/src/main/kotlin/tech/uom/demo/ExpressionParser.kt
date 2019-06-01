package tech.uom.demo

import tech.units.indriya.unit.Units
import java.lang.IllegalArgumentException

class ExpressionParser {

    private val unitNames = Units.getInstance().getUnits().map{unit ->
        unit.getName()

    }


    fun parse(tokens: List<Token>): ParseElement {

        val unitValue = tokens[1].value
        if ( !unitNames.contains(unitValue)){
            throw IllegalArgumentException("I don't know any unit called $unitValue")
        }

        return QuantityElement(value=tokens[0].value, unit=tokens[1].value)
    }

}


data class Token(val value:String)