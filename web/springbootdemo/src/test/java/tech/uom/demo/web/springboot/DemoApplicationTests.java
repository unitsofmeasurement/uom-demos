package tech.uom.demo.web.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		ConversionController controller = new ConversionController();
		Double result = (Double) controller.doDemo("1").getTargetValue();
		assertEquals(result,new Double(1000*1000));
	}
}
