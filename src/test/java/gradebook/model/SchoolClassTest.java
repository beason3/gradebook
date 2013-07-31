package gradebook.model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class SchoolClassTest {
	private SchoolClass schoolClass;
	private Section A100;
	private ArrayList<Section> sections;

	@Before
	public void setUp(){
		schoolClass = new SchoolClass("Calculus 1");
		A100 = new Section(schoolClass);
		sections = new ArrayList<Section>();
	}

	@Test
	public void addSectionTest(){
		schoolClass.addSection(A100);
		sections.add(A100);
		assertEquals(sections,schoolClass.getSections());
	}
	
	@Test
	public void calculateAverageTest(){
		schoolClass.calculateAverage();
		assertTrue(0==schoolClass.getAverageScore());
	}
	
	@Test
	public void getSectionsTest(){
		schoolClass.addSection(A100);
		sections.add(A100);
		assertEquals(sections,schoolClass.getSections());
	}
	
	@Test
	public void getAverageScoreTest(){
		assertTrue(0==schoolClass.getAverageScore());
	}
	
	@Test
	public void getLetterGradeTest(){
		assertTrue('F'==schoolClass.getLetterGrade());
	}
	
	@Test
	public void getNameTest(){
		assertEquals("Calculus 1", schoolClass.getName());
	}
	
	@Test
	public void toStringTest(){
		assertEquals("Name: Calculus 1 Average: 0.0 Grade: F", schoolClass.toString());
	}
	
	@Test
	public void toStringSectionsTest(){
		schoolClass.addSection(A100);
		assertEquals("Name: Calculus 1 Average: 0.0 Grade: F\nClass Name: "+
				"Calculus 1 Average: 0.0 Grade: F",schoolClass.toStringSections());
	}
}
