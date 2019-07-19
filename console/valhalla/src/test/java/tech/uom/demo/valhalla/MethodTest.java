package tech.uom.demo.valhalla;

import static org.junit.Assert.*;

import org.junit.Test;

	/*
	 * @test
	 * @summary Test inline classes with Reference types
	 */
	public class MethodTest {

	    @Test
	    public void test1() {
	        VUnit u = VUnit.of("kg","kilogram");
	        System.out.println(u);
	        assertEquals("kg", u.getSymbol());
	    }

}
