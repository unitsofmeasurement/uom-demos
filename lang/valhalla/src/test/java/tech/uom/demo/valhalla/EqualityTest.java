package tech.uom.demo.valhalla;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

	/*
	 * @test
	 * @summary Test value classes for equality
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
