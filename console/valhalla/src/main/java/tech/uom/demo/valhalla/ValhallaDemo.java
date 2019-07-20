package tech.uom.demo.valhalla;

public class ValhallaDemo {
	private static final String PATTERN = "%s and %s are %s.";
	private static final String SAME = "the same";
	private static final String NOT_SAME = "not the same";
	
	public static void main(String[] args) {
        VUnit m1 = VUnit.of("kg","kilogram");
        VUnit m2 = VUnit.of("kg","kilogram");
        System.out.println(m1);
        if (m1 == m2) {
        	System.out.println(String.format(PATTERN, m1, m2, SAME));
        } else {
        	System.out.println(String.format(PATTERN, m1, m2, NOT_SAME));
        }
        
        VUnit m3 = VUnit.of("g","gram");
        if (m1 == m3) {
        	System.out.println(String.format(PATTERN, m1, m3, SAME));
        } else {
        	System.out.println(String.format(PATTERN, m1, m3, NOT_SAME));
        }
	}

}
