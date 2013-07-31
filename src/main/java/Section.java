package gradebook.model;
import java.util.*;

public class Section{
private SchoolClass sectionSchoolClass;
private ArrayList<Student> students;
private double score;
private char letterGrade;

public Section(SchoolClass new_class){
	this.students = new ArrayList<Student>();
	this.sectionSchoolClass = new_class;
	this.score = 0;
	this.letterGrade = 'F';
}

public Section(){
	this.score = 0;
	this.letterGrade = 'F';
	this.students = new ArrayList<Student>();
}

public double calculateAverage(){
	double total = 0;
	double size = (double)students.size();
	for(int i = 0; i < students.size(); i++){
		total = total + students.get(i).calculateAverage();
	}
	if(!students.isEmpty()){
		score = total/size;
	}
	else {
		score = 0;
	}
	if(score>=90){
		letterGrade = 'A';
	}
	else if(score>=80){
		letterGrade = 'B';
	}
	else if(score>=70){
		letterGrade = 'C';
	}
	else if(score>=60){
		letterGrade = 'D';
	}
	else{
		letterGrade = 'F';
	}
	return score;
}

public void setClass(SchoolClass new_class){
	this.sectionSchoolClass = new_class;
}

public void addStudent(Student new_student){
	students.add(new_student);
}

public SchoolClass getSchoolClass(){
	return sectionSchoolClass;
}

public ArrayList<Student> getStudents(){
	return students;
}

public double getScore(){
	return score;
}

public char getLetterGrade(){
	return letterGrade;
}

public String toString(){
	return "Class Name: "+sectionSchoolClass.getName()+" Average: "+score+" Grade: "+letterGrade;
}

}