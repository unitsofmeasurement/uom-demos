package tech.uom.demo.web.springboot;

public class ConversionInput {
	private Number value;
	private String unit;
	private String prefix;

	private String targetUnit;
	private String targetPrefix;

	public Number getValue() {
		return value;
	}
	public void setValue(Number value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getTargetUnit() {
		return targetUnit;
	}

	public void setTargetUnit(String targetUnit) {
		this.targetUnit = targetUnit;
	}

	public String getTargetPrefix() {
		return targetPrefix;
	}

	public void setTargetPrefix(String targetPrefix) {
		this.targetPrefix = targetPrefix;
	}
	
	public static ConversionInput createForDemo(Long input) {
		ConversionInput demo = new ConversionInput(); 
		demo.setPrefix("KILO");
		demo.setTargetPrefix("MILLI");
		demo.setTargetUnit("m");
		demo.setUnit("m");
		demo.setValue(input);
		return demo; 
	}
}
