package tech.uom.demo.valhalla;

import static org.junit.Assert.*;

import org.junit.Test;

	/*
	 * @test
	 * @summary Test inline classes and its methods
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
