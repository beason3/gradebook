package gradebook.model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class SectionTest {
	private Section A100;
	private Section A200;
	private ArrayList<Student> students;
	private SchoolClass math;
	private SchoolClass physics;
	private Student bob;

	@Before
	public void setUp(){
		math = new SchoolClass("Math");
		physics = new SchoolClass("Physics");
		A100 = new Section(math);
		A200 = new Section();
		students = new ArrayList<Student>();
		bob = new Student("Bob");
	}

	@Test
	public void calculateAverageTest(){
		assertTrue(0==A100.calculateAverage());
	}

	@Test 
	public void setClassTest(){
		A200.setClass(physics);
		assertEquals(physics,A200.getSchoolClass());
	}
	
	@Test
	public void addStudentTest(){
		A100.addStudent(bob);
		students.add(bob);
		assertEquals(students,A100.getStudents());
	}
	
	@Test
	public void getSchoolClassTest(){
		assertEquals(math, A100.getSchoolClass());
	}
	
	@Test
	public void getStudentsTest(){
		students.add(bob);
		A200.addStudent(bob);;
		assertEquals(students,A200.getStudents());
	}
	
	@Test
	public void getScoreTest(){
		assertTrue(0==A100.getScore());
	}
	
	@Test
	public void getLetterGradeTest(){
		assertTrue('F'==A100.getLetterGrade());
	}
	
	@Test
	public void toStringTest(){
		assertEquals("Class Name: Math Average: 0.0 Grade: F", A100.toString());
	}
}
