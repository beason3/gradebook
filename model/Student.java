package gradebook.model;
import java.util.*;

public class Student{
private String name;
private ArrayList<GradebookItem> gbItems;
private double average;
private char letterGrade;
private GradingScheme grading;

public Student(String new_name, ArrayList<GradebookItem> items){
	this.name = new_name;
	this.gbItems = (ArrayList<GradebookItem>)items.clone();
	this.average = 0;
	this.letterGrade = 'F';
}

public Student(String new_name){
this.name = new_name;
this.gbItems = new ArrayList<GradebookItem>();
this.average = 0;
this.letterGrade = 'F';
}

public double calculateAverage(){
	this.grading = new GradingScheme(gbItems);
	average = grading.calculateGrade();
	if(average>=90){
		letterGrade = 'A';
	}
	else if(average>=80){
		letterGrade = 'B';
	}
	else if(average>=70){
		letterGrade = 'C';
	}
	else if(average>=60){
		letterGrade = 'D';
	}
	else{
		letterGrade = 'F';
	}
	gbItems = grading.getGBItems();
	return average;
}

public void addGBItem(GradebookItem new_item){
	gbItems.add(new_item);
}

public String getName(){
	return name;
}

public ArrayList<GradebookItem> getGradebookItems(){
	return gbItems;
}

public double getAverage(){
	return average;
}

public char getLetterGrade(){
	return letterGrade;
}

public String toString(){
	return "Name: "+name+" Average: "+average+" Grade: "+letterGrade;
}

}