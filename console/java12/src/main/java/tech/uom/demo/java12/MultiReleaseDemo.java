package tech.uom.demo.java12;
import static javax.measure.MetricPrefix.KILO;
import static tech.units.indriya.unit.Units.VOLT;

import tech.units.indriya.AbstractUnit;
import tech.units.indriya.format.FormatBehavior;
import tech.units.indriya.format.NumberFormatStyle;
import tech.units.indriya.format.NumberDelimiterQuantityFormat;

import javax.measure.spi.ServiceProvider;
import tech.units.indriya.quantity.Quantities;

public class MultiReleaseDemo {
    public static void main(String[] args) {
        var parsed = AbstractUnit.parse("%");
        System.out.println(parsed);

        parsed = AbstractUnit.parse("W");
        System.out.println(parsed);

        var unitFormat = ServiceProvider.current().getFormatService().getUnitFormat();
        parsed = unitFormat.parse("V");
        System.out.println(parsed);

        var u = ServiceProvider.current().getFormatService().getUnitFormat().parse("g/l");
        System.out.println(u);
        var formatStyle = NumberFormatStyle.DEFAULT;
        var quantFormat = NumberDelimiterQuantityFormat.getCompactInstance(FormatBehavior.LOCALE_NEUTRAL);
        System.out.println(formatStyle);
        var vQuant = Quantities.getQuantity(10000, VOLT);
        System.out.println(quantFormat.format(vQuant));
        var vQuant2 = Quantities.getQuantity(10, KILO(VOLT));
        System.out.println(quantFormat.format(vQuant2));
        System.out.println(vQuant.isEquivalentTo(vQuant2));
    }
}
