package gradebook.model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


import java.util.*;


public class CourseTest{
private Course course;
private Course prereq;
private SchoolClass schoolClass;
private ArrayList<Course> prereqList;
private ArrayList<SchoolClass> schoolClassList;
private Course dummy;

@Before
public void setUp(){
	course = new Course("Math",2110,"Math 2110");
	dummy = new Course("Math",2110,"Math 2110");
	prereq = new Course("Math",10000,"Calc 1");
	schoolClass = new SchoolClass();
	prereqList = new ArrayList<Course>();
	schoolClassList = new ArrayList<SchoolClass>();
}

@Test
public void addPrereqTest(){
	course.addPrereq(prereq);
	boolean compare = course==dummy;
	assertFalse(compare);
}

@Test
public void addSchoolClassesTest(){
	course.addSchoolClasses(schoolClass);
	boolean compare = course==dummy;
	assertFalse(compare);
}

@Test
public void calculateAverageTest(){
	course.addSchoolClasses(schoolClass);
	assertTrue(0==course.calculateAverage());
}

@Test
public void getSchoolClassesTest(){
	course.addSchoolClasses(schoolClass);
	schoolClassList.add(schoolClass);
	assertEquals(schoolClassList,course.getSchoolClasses());
}

@Test
public void getSubjectTest(){
	assertEquals("Math",course.getSubject());
}

@Test
public void getCourseNumberTest(){
	assertEquals(2110,course.getCourseNumber());
}

@Test
public void getNameTest(){
	assertEquals("Math 2110", course.getName());
}

@Test
public void getPrereqTest(){
	course.addPrereq(prereq);
	prereqList.add(prereq);
	assertEquals(prereqList,course.getPrereq());
}

@Test
public void getAverageTest(){
	assertTrue(0==course.getAverage());
}

@Test
public void getLetterGradeTest(){
	assertEquals('F',course.getLetterGrade());
}

@Test
public void prereqToStringTest(){
	assertEquals("none", course.prereqToString());
}

@Test
public void toStringTest(){
	assertEquals("Name: Math 2110 Course Number: 2110 Subject: Math Prereq: none",
		course.toString());
}

}
