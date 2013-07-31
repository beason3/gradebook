package gradebook.model;

public class GradebookItem{
private double score;
private String name;
private GradebookCategory gbCategory;

public GradebookItem(String new_name, GradebookCategory new_gb, double new_score){
this.name = new_name;
this.gbCategory = new_gb;
this.score = new_score;
}

public GradebookItem(String new_name, GradebookCategory new_gb){
this.name = new_name;
this.gbCategory = new_gb;
this.score = 0;
}

public void setScore(double new_score){
	score = new_score;
}

public double getScore(){
	return score;
}

public String getName(){
	return name;
}

public GradebookCategory getGradebookCategory(){
	return gbCategory;
}

}