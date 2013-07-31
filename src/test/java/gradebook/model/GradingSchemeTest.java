package gradebook.model;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class GradingSchemeTest {
private GradingScheme gbScheme;
private ArrayList<GradebookItem> gbItems;
private GradebookCategory tests;
private GradebookCategory quizzes;
private GradebookCategory homework;
	
	@Before
	public void setUp(){
		tests = new GradebookCategory("Tests",.5);
		quizzes = new GradebookCategory("Quizzes", .25);
		homework = new GradebookCategory("Homework", .25);
		gbItems = new ArrayList<GradebookItem>();
		GradebookItem test1 = new GradebookItem("Test 1", tests, 100);
		GradebookItem test2 = new GradebookItem("Test 2", tests, 80);
		GradebookItem test3 = new GradebookItem("Test 3", tests, 90);
		GradebookItem quiz1 = new GradebookItem("Quiz 1", quizzes, 100);
		GradebookItem quiz2 = new GradebookItem("Quiz 2", quizzes, 50);
		GradebookItem quiz3 = new GradebookItem("Quiz 3", quizzes, 80);
		GradebookItem hw1 = new GradebookItem("HW1", homework, 80);
		GradebookItem hw2 = new GradebookItem("HW2", homework, 70);
		GradebookItem hw3 = new GradebookItem("HW3", homework, 55);
		gbItems.add(test1);
		gbItems.add(test2);
		gbItems.add(test3);
		gbItems.add(quiz1);
		gbItems.add(quiz2);
		gbItems.add(quiz3);
		gbItems.add(hw1);
		gbItems.add(hw2);
		gbItems.add(hw3);
		gbScheme = new GradingScheme(gbItems);
	}
	
	@Test
	public void calculateGradeTest(){
		double average = gbScheme.calculateGrade();
		assertTrue(88.75==average);
		ArrayList<GradebookItem> new_gbItems = gbScheme.getGBItems();
		assertTrue(new_gbItems.get(1).getScore()==95);
		assertTrue(new_gbItems.get(4).getScore()==90);
		assertTrue(new_gbItems.get(8).getScore()==75);
	}
	
	@Test
	public void getGBItemsTest(){
		assertEquals(gbItems, gbScheme.getGBItems());
	}

}
