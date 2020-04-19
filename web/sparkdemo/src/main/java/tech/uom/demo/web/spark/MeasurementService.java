/*
Copyright 2016-2020 Werner Keil and others

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/
package tech.uom.demo.web.spark;

import java.util.*;

import javax.measure.Unit;

import tech.units.indriya.AbstractUnit;

public class MeasurementService {

	private Map<String, Measurement> measures = new HashMap<>();

	public List<Measurement> getAllMeasurements() {
		return new ArrayList<>(measures.values());
	}

	public Measurement getMeasurement(String id) {
		return measures.get(id);
	}

	public Measurement createMeasurement(String name, Number val, Unit<?> unit) {
		failIfInvalid(name, val);
		Measurement m = new Measurement(name, val, unit.toString());
		measures.put(m.getId(), m);
		return m;
	}

	public Measurement createMeasurement(String name, Number val, String unit) {
		failIfInvalid(name, val);
		Measurement m = new Measurement(name, val, unit);
		measures.put(m.getId(), m);
		return m;
	}

	public Measurement createMeasurement(String name, String val, String unit) {
		return createMeasurement(name, Double.parseDouble(val), unit);
	}

	public Measurement createMeasurement(String name, String val) {
		return createMeasurement(name, Double.valueOf(val), "");
	}

	public Measurement updateMeasurement(String id, String name, Number val, Unit<?> unit) {
		Measurement measure = measures.get(id);
		if (measure == null) {
			throw new IllegalArgumentException("No measurement with id '" + id + "' found");
		}
		failIfInvalid(name, val);
		measure.setName(name);
		measure.setValue(val);
		return measure;
	}

	public Measurement updateMeasurement(String id, String name, String val, String unit) {
		return updateMeasurement(id, name, Double.parseDouble(val), AbstractUnit.parse(unit));
	}

	private void failIfInvalid(String name, Number val) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'name' cannot be empty");
		}
		if (val == null) {
			throw new IllegalArgumentException("Parameter 'value' cannot be empty");
		}
	}
}
