package gradebook.model;
import java.util.*;

public class Course{
private ArrayList<SchoolClass> classes;
private String subject;
private int courseNumber;
private String name;
private ArrayList<Course> prereq;
private double averageScore;
private char letterGrade;


public Course(String new_subject, int new_courseNumber, String new_name){
	this.subject = new_subject;
	this.courseNumber = new_courseNumber;
	this.name = new_name;
	this.averageScore = 0;
	this.letterGrade = 'F';
	this.classes = new ArrayList<SchoolClass>();
	this.prereq = new ArrayList<Course>();
}

public void addPrereq(Course new_prereq){
	prereq.add(new_prereq);
}

public void addSchoolClasses(SchoolClass new_class){
	classes.add(new_class);
}

public double calculateAverage(){
double total = 0;
	double size = (double)classes.size();
	for(int i = 0; i < classes.size(); i++){
		total = total + classes.get(i).calculateAverage();
	}
	if(!classes.isEmpty()){
		averageScore = total/size;
	}
	else{
		averageScore = 0;
	}
	if(averageScore>=90){
		letterGrade = 'A';
	}
	else if(averageScore>=80){
		letterGrade = 'B';
	}
	else if(averageScore>=70){
		letterGrade = 'C';
	}
	else if(averageScore>=60){
		letterGrade = 'D';
	}
	else{
		letterGrade = 'F';
	}
return averageScore;
}

public ArrayList<SchoolClass> getSchoolClasses(){
	return classes;
}

public String getSubject(){
	return subject;
}

public int getCourseNumber(){
	return courseNumber;
}

public String getName(){
	return name;
}

public ArrayList<Course> getPrereq(){
	return prereq;
}

public double getAverage(){
	return averageScore;
}

public char getLetterGrade(){
	return letterGrade;
}

public String prereqToString(){
	String s = "";
	for(int i = 0; i < prereq.size(); i++){
		String n = prereq.get(i).getName();
		s=s+n+", ";
	}
	if(prereq.size()==0){
		return "none";
	}
	return s;
}

public String toString(){
	return "Name: "+name+" Course Number: "+courseNumber+" Subject: "+subject+
		" Prereq: "+prereqToString();
}

}
