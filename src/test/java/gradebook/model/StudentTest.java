package gradebook.model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class StudentTest {
	private ArrayList<GradebookItem> gbItems;
	private GradingScheme gbScheme;
	private Student bob;
	private GradebookItem test1;
	private GradebookItem test2;
	private GradebookItem project1;
	private GradebookCategory tests;
	private GradebookCategory projects;
	
	@Before
	public void setUp(){
		gbItems = new ArrayList<GradebookItem>();
		gbScheme = new GradingScheme(gbItems);
		tests = new GradebookCategory("Tests",.5);
		projects = new GradebookCategory("Projects",.5);
		test1 = new GradebookItem("Test 1", tests, 90);
		test2 = new GradebookItem("Test 2", tests, 80);
		project1 = new GradebookItem("Projects",projects, 100);		
		gbItems.add(test1);
		gbItems.add(project1);
		bob = new Student("Bob",gbItems);
	}	
	
	@Test
	public void calculateAverageTest(){
		assertTrue(95.0==bob.calculateAverage());
	}
	
	@Test
	public void getNameTest(){
		assertEquals("Bob",bob.getName());
	}
	
	@Test
	public void addGBItemTest(){
		bob.addGBItem(test2);
		gbItems.add(test2);
		assertEquals(gbItems,bob.getGradebookItems());
	}
	
	@Test
	public void getGradebookItemsTest(){
		assertEquals(gbItems,bob.getGradebookItems());
	}
	
	@Test
	public void getAverageTest(){
		assertTrue(bob.calculateAverage()==bob.getAverage());
	}
	
	@Test
	public void getLetterGradeTest(){
		double average = bob.calculateAverage();
		char grade ='C';
		if(average>=90){
			grade = 'A';
		}
		assertEquals(grade,bob.getLetterGrade());
	}
	
	@Test
	public void toStringTest(){
		double average = bob.calculateAverage();
		assertEquals("Name: Bob Average: "+average+" Grade: A", bob.toString());
	}
}

