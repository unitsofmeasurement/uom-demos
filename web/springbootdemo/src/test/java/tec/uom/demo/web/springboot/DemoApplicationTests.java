package tec.uom.demo.web.springboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		ConversionController controller = new ConversionController();
		Double result = (Double) controller.doDemo("1").getTargetValue();
		Assert.assertEquals(result,new Double(1000*1000));
	}

}
