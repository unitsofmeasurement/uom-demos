package tec.uom.demo.energy;

import static tec.uom.se.unit.MetricPrefix.*;
import javax.measure.Unit;
import javax.measure.quantity.Energy;
import tec.uom.se.AbstractSystemOfUnits;
import tec.uom.se.format.SimpleUnitFormat;
import tec.uom.se.function.RationalConverter;
import tec.uom.se.unit.TransformedUnit;
import tec.uom.se.unit.Units;

/**
 * <p>
 * This class contains units for demo purposes.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.1, $Date: 2015-10-15 $
 */
public final class DemoUnitSystem extends AbstractSystemOfUnits {
    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private DemoUnitSystem() {
    }
    
    /**
     * The singleton instance of {@code Health}.
     */
    private static final DemoUnitSystem INSTANCE = new DemoUnitSystem();

	@Override
	public String getName() {
		return "Demo";
	}
	
    /**
     * Adds a new unit not mapped to any specified quantity type.
     *
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>>  U addUnit(U unit) {
        INSTANCE.units.add(unit);
        return unit;
    }
    
	public static final Unit<Energy> WATTHOUR = 
			new TransformedUnit<Energy>("Wh", Units.JOULE, new RationalConverter(3600, 1));
    
	// //////////////////////////////////////////////////////////////////////////
	// Label adjustments
	static {
		SimpleUnitFormat.getInstance().label(WATTHOUR, "Wh");
		SimpleUnitFormat.getInstance().label(KILO(WATTHOUR), "KWh");
	}
}
