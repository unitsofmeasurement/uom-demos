package tech.uom.demo.valhalla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

	/*
	 * @test
	 * @summary Test value classes and their methods
	 */
	public class MethodTest {

	    @Test
	    public void testGetSymbol() {
	        VUnit u = VUnit.of("kg","kilogram");
	        //System.out.println(u);
	        assertEquals("kg", u.getSymbol());
	    }
	    
	    @Test
	    public void testGetName() {
	        VUnit u = VUnit.of("kg","kilogram");
	        //System.out.println(u);
	        assertEquals("kilogram", u.getName());
	    }

}
