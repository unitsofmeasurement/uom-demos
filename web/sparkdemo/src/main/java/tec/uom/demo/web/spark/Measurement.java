package tec.uom.demo.web.spark;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.UUID;

public class Measurement {
//    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy MM dd");
    
    private String id;
    private String name;
    private Number value;
    private String unit;
    private Temporal timestamp;

    public Measurement(String name, Number value, String unit) {
	this.id = UUID.randomUUID().toString();
	this.name = name;
	this.value = value;
	this.unit = unit;
	this.timestamp = LocalDateTime.now();
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public Temporal getTimestamp() {
        return timestamp;
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
