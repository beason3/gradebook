package gradebook.model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class GradebookItemTest {
	GradebookItem gbItem;
	GradebookCategory tests;

	@Before
	public void setUp(){
		tests = new GradebookCategory("Tests",.2);
		gbItem = new GradebookItem("Test 1", tests);	
	}

	@Test
	public void setScoreTest(){
		gbItem.setScore(80);
		assertTrue(gbItem.getScore()==80);
	}
	
	@Test
	public void getScoreTest(){
		gbItem.setScore(90);
		assertTrue(90==gbItem.getScore());
	}
	
	@Test
	public void getNameTest(){
		assertTrue("Test 1"==gbItem.getName());
	}
	
}