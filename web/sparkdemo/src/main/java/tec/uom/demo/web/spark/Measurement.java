package tec.uom.demo.web.spark;

import java.util.UUID;

import javax.measure.Unit;

public class Measurement {

	private String id;
	private String name;
	private Number value;
	private String unit;

	public Measurement(String name, Number value, String unit) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.value = value;
		this.unit = unit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getValue() {
		return value;
	}

	public void setValue(Number val) {
		this.value = val;
	}

	public String getUnit() {
	    return unit;
	}

	public void setUnit(String unit) {
	    this.unit = unit;
	}

}
