package tech.uom.demo.valhalla;

import static org.junit.Assert.*;

import org.junit.Test;

	/*
	 * @test
	 * @summary Test inline classes for equality
	 */
	public class EqualityTest {

	    @Test
	    public void testSame() {
	        VUnit u1 = VUnit.of("kg","kilogram");
	        VUnit u2 = VUnit.of("kg","kilogram");
	        //System.out.println(u);
	        assertTrue(u1 == u2);
	    }
	    
	    @Test
	    public void testDifferent() {
	        VUnit u1 = VUnit.of("kg","kilogram");
	        VUnit u2 = VUnit.of("g","gram");
	        //System.out.println(u);
	        assertFalse(u1 == u2);
	    }
	    
	    @Test
	    public void testEqual() {
	        VUnit u1 = VUnit.of("kg","kilogram");
	        VUnit u2 = VUnit.of("kg","kilogram");
	        //System.out.println(u);
	        assertEquals(u1, u2);
	    }
}
