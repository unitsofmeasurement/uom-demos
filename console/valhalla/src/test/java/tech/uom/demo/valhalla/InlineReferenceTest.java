package tech.uom.demo.valhalla;

import static org.junit.Assert.*;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import org.junit.Test;

	/*
	 * @test
	 * @summary Test inline classes with Reference types
	 * @run testng/othervm InlineReferenceTest
	 */
	public class InlineReferenceTest {

	    @Test(expected = IllegalArgumentException.class)
	    static void test1() {
	        VUnit? p = new VUnit("k","kilogram");
	        WeakReference<VUnit?> r = new WeakReference<>(p);
	    }

	    @Test(expected = IllegalArgumentException.class)
	    static void test2() {
	        ReferenceQueue<Object> q = new ReferenceQueue<>();
	        VUnit? p = new VUnit("k","kilogram");
	        WeakReference<VUnit?> r = new WeakReference<>(p, q);
	    }

}
