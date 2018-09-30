package tec.uom.demo.systems.ucum;

import static systems.uom.ucum.UCUM.*;
import static tec.uom.se.unit.MetricPrefix.KILO;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Frequency;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Time;
import javax.measure.quantity.Volume;

import systems.uom.ucum.UCUM;
import systems.uom.ucum.format.UCUMFormat;
import systems.uom.ucum.format.UCUMFormat.Variant;
import tec.uom.se.format.EBNFUnitFormat;
import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.Units;

public class UCUMDemoSE {

    public static void main(String[] args) {
        Unit<Mass> atomicMassUnit = ATOMIC_MASS_UNIT;
        System.out.println(atomicMassUnit.getSymbol());

        Quantity<Mass> mass = (Quantity<Mass>) Quantities.getQuantity(10, atomicMassUnit);
        System.out.println(mass);

        Quantity<Mass> massInKg = mass.to(Units.KILOGRAM);
        System.out.println(massInKg);

        UnitFormat cs = UCUMFormat.getInstance(Variant.CASE_SENSITIVE);
        Unit<?> unit = cs.parse("m/s");
        System.out.println(unit);

        // unit = format.parse("m^1*s^-1");
        // System.out.println(unit);

        System.out.println(UCUM.PARSEC);
        UnitFormat print = UCUMFormat.getInstance(Variant.PRINT);
        System.out.println(print.format(UCUM.PARSEC));

        Unit<Frequency> hz = UCUM.HERTZ;
        System.out.println(hz);
        System.out.println(hz.getBaseUnits());
        System.out.println(print.format(UCUM.HERTZ));

        Unit<Frequency> khz = KILO(hz);
        System.out.println(khz.getBaseUnits());

        unit = cs.parse("Hz");
        System.out.println(unit);
        unit = cs.parse("kHz");
        System.out.println(unit);

        // UnitFormat ebnf = EBNFUnitFormat.getInstance();
        // unit = ebnf.parse("MHz");
        // System.out.println(unit);

        Quantity<Volume> oneLiter = Quantities.getQuantity(1, LITER);
        System.out.println(oneLiter.to(LITER_DM3).getValue());

    }
}
