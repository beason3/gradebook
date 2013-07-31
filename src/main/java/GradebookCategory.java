package gradebook.model;
import java.util.*;

public class GradebookCategory{
private String name;
private double weight;

public GradebookCategory(String new_name, double new_weight){
this.name = new_name;
this.weight = new_weight;
}

public String getName(){
	return name;
}

public double getWeight(){
	return weight;
}

}