package tech.uom.demo.valhalla;

import javax.measure.*;
import java.util.Map;

public value class VUnit<Q extends Quantity<Q>> implements Unit<Q> {

		private final String x;
        private final String y;

        public static VUnit of(String x, String y) {
            return new VUnit(x, y);
        }

        private VUnit(String x, String y) {
            this.x = x;
            this.y = y;
        }


    @Override
    public String getSymbol() {
        return x;
    }

    @Override
    public String getName() {
        return y;
    }

    @Override
    public Dimension getDimension() {
        return null;
    }

    @Override
    public Unit<Q> getSystemUnit() {
        return null;
    }

    @Override
    public Map<? extends Unit<?>, Integer> getBaseUnits() {
        return null;
    }

    @Override
    public Unit<Q> alternate(String symbol) {
        return null;
    }

    @Override
    public Unit<Q> shift(Number offset) {
        return null;
    }

    @Override
    public Unit<Q> shift(double offset) {
        return null;
    }

    @Override
    public Unit<Q> multiply(Number multiplier) {
        return null;
    }

    @Override
    public Unit<Q> multiply(double multiplier) {
        return null;
    }

    @Override
    public Unit<?> inverse() {
        return null;
    }

    @Override
    public Unit<Q> divide(Number divisor) {
        return null;
    }

    @Override
    public Unit<Q> divide(double divisor) {
        return null;
    }


    @Override
    public Unit<?> root(int n) {
        return null;
    }

    @Override
    public Unit<?> pow(int n) {
        return null;
    }

    @Override
    public Unit<Q> transform(UnitConverter operation) {
        return null;
    }

    @Override
    public Unit<Q> prefix(Prefix prefix) {
        return null;
    }

    @Override
    public String toString() {
    	return "VUnit [symbol=" + x + ", name=" + y + "]";
    }

	@Override
	public boolean isEquivalentTo(Unit that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompatible(Unit that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Unit asType(Class type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterTo(Unit that) throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterToAny(Unit that) throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit multiply(Unit multiplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit divide(Unit divisor) {
		// TODO Auto-generated method stub
		return null;
	}

}
