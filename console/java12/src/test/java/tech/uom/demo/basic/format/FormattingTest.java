package tech.uom.demo.basic.format;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tech.units.indriya.format.NumberDelimiterQuantityFormat;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.quantity.Quantities;
import tech.units.indriya.unit.Units;

import java.math.RoundingMode;
import java.text.*;
import java.util.Locale;

class FormattingTest {

	@Test
	void testFractionDigits() {
		
	    var floorAfter4Digits = NumberFormat.getNumberInstance(Locale.ENGLISH);
	    floorAfter4Digits.setMaximumFractionDigits(4);
	    floorAfter4Digits.setRoundingMode(RoundingMode.FLOOR);	    
	    
	    var floorAfter2Digits = NumberFormat.getNumberInstance(Locale.ENGLISH);
	    floorAfter2Digits.setMaximumFractionDigits(2);
	    floorAfter2Digits.setRoundingMode(RoundingMode.FLOOR);
	    
	    var floorQuantityAfter4Digits = NumberDelimiterQuantityFormat
	    	      .builder()
	    	      .setNumberFormat(floorAfter4Digits) // <-- reusing formatter from above
	    	      .setUnitFormat(SimpleUnitFormat.getInstance())
	    	      .build();
	    var floorQuantityAfter2Digits = NumberDelimiterQuantityFormat
	    	      .builder()
	    	      .setNumberFormat(floorAfter2Digits) // <-- reusing formatter from above
	    	      .setUnitFormat(SimpleUnitFormat.getInstance())
	    	      .build();
		
	    var double30001 = 3.0001;
	    	    var quantity30001 = Quantities.getQuantity(double30001, Units.NEWTON);
	    	    assertEquals("3.0001", floorAfter4Digits.format(double30001));
	    	    assertEquals("3", floorAfter2Digits.format(double30001));
	    	    assertEquals("3", floorAfter2Digits.format(quantity30001.getValue()));
	    	    assertEquals("3 N", floorQuantityAfter2Digits.format(quantity30001));
	    	    assertEquals("3.0001 N", floorQuantityAfter4Digits.format(quantity30001));
	}

}
