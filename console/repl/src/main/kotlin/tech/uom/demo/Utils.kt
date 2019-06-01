package tech.uom.demo

import tech.units.indriya.quantity.Quantities
import javax.measure.Quantity
import javax.measure.Unit


fun <Q : Quantity<Q>> q(value: Number, unit: Unit<Q>) = Quantities.getQuantity(value,unit)