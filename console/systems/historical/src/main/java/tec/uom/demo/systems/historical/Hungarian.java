package tec.uom.demo.systems.historical;

import static javax.measure.MetricPrefix.*;
import static tech.units.indriya.unit.Units.*;

import java.util.Objects;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;

import tech.units.indriya.AbstractSystemOfUnits;
import tech.units.indriya.format.SimpleUnitFormat;

/**
 * <p>
 * This class contains units from the Historical Hungarian system.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.2, $Date: 2019-04-15 $
 * @see <a href="http://en.wikipedia.org/wiki/Hungarian_units_of_measurement">Wikipedia: Hungarian units of measurement</a>
 */
public final class Hungarian extends AbstractSystemOfUnits {
    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private Hungarian() {
    }

    /**
     * The singleton instance of {@code Health}.
     */
    private static final Hungarian INSTANCE = new Hungarian();

    @Override
    public String getName() {
        return "Hungarian units of measurement";
    }

    // TODO can remove after upgrade to Indriya 2
    @Override
    public Unit<?> getUnit(String string) {
        Objects.requireNonNull(string);
        return this.getUnits().stream().filter((u) -> string.equals(u.toString())).findAny().orElse(null);
    }

    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param unit
     *            the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }

    /**
     * A unit of length equal to <code>8.3536 km</code> (standard name <code>mtf</code>).
     */
    public static final Unit<Length> MERTFOELD = addUnit(KILO(METRE).multiply(8.3536));

    /**
     * A unit of volume equal to <code>54.30 l</code> (standard name <code>e</code>). While a bit larger, the eimer would roughly be comparable to a
     * "pitcher" of beer or a similar drink.
     */
    public static final Unit<Volume> EIMER = addUnit(LITRE.multiply(54.30));

    // //////////////////////////////////////////////////////////////////////////
    // Label adjustments for Hungarian system
    static {
        SimpleUnitFormat.getInstance().label(MERTFOELD, "mtf");
        SimpleUnitFormat.getInstance().label(EIMER, "e");
    }
}
