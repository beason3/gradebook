package gradebook.model;
import java.util.*;

public class SchoolClass{
private ArrayList<Section> sections;
private double averageScore;
private char letterGrade;
private String name;

public SchoolClass(Section new_section,String new_name){
	this.sections = new ArrayList<Section>();
	sections.add(new_section);
	this.averageScore = 0;
	this.letterGrade = 'F';
	this.name = new_name;
}

public SchoolClass(String new_name){
	this.sections = new ArrayList<Section>();
	this.averageScore = 0;
	this.letterGrade = 'F';
	this.name = new_name;
}

public SchoolClass(){
	this.sections = new ArrayList<Section>();
	this.averageScore = 0;
	this.letterGrade = 'F';
	this.name = "Class 101";
}

public void addSection(Section new_section){
	sections.add(new_section);
}

public double calculateAverage(){
	double total = 0;
	double size = (double)sections.size();
	for(int i = 0; i < sections.size(); i++){
		total = total + sections.get(i).calculateAverage();
	}
	if(!sections.isEmpty()){
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

public ArrayList<Section> getSections(){
	return sections;
}

public double getAverageScore(){
	return averageScore;
}

public char getLetterGrade(){
	return letterGrade;
}

public String getName(){
	return name;
}

public String toString(){
	return "Name: "+name+" Average: "+averageScore+" Grade: "+letterGrade;
}

public String toStringSections(){
	String s = toString();
	for(int i = 0; i < sections.size(); i++){
		s = s+"\n"+sections.get(i).toString();
	}
	return s;
}

}