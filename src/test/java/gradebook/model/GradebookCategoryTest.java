package gradebook.model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GradebookCategoryTest {
	private GradebookCategory gbCat;

	@Before
	public void setUp(){
		gbCat = new GradebookCategory("Test", .2);
	}

	@Test
	public void getNameTest(){
		assertEquals("Test",gbCat.getName());
	}
	
	@Test
	public void getWeightTest(){
		assertTrue(.2==gbCat.getWeight());
	}

}
