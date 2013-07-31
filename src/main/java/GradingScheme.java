package gradebook.model;
import java.util.*;

public class GradingScheme{
private ArrayList<GradebookItem> gbItems;

public GradingScheme(){
	this.gbItems = new ArrayList<GradebookItem>();
}

public GradingScheme(ArrayList<GradebookItem> newgbItems){
this.gbItems = newgbItems;
}

public GradingScheme(GradebookItem gbItem){
	this.gbItems = new ArrayList<GradebookItem>();
	gbItems.add(gbItem);
}

public void addGBItem(GradebookItem gbItem){
	this.gbItems.add(gbItem);
}

public double calculateGrade(){
	double total = 0;
	double size;
	double lowestScore;
	double temp_lowest = 0;
	double average = 0;
	double gbAverage = 0;
	ArrayList<GradebookItem> dummy = new ArrayList<GradebookItem>();
	ArrayList<GradebookItem> temp = (ArrayList<GradebookItem>)gbItems.clone();
	while(!temp.isEmpty()){
		int k = 0;
		int s = temp.size();
		String gbCategoryName = temp.get(0).getGradebookCategory().getName();
		while(k<s){
			if(temp.get(k).getGradebookCategory().getName().equals(gbCategoryName)){
				dummy.add(temp.get(k));
				temp.remove(k);
				s = temp.size();
			}
			else{
				k++;
			}
		}
		if (dummy.size()>1){
			lowestScore = dummy.get(0).getScore();
			temp_lowest = lowestScore;
			//gets the lowest score
			for(int i = 0; i < dummy.size(); i++){
				if(dummy.get(i).getScore()<lowestScore){
					lowestScore = dummy.get(i).getScore();
					temp_lowest = lowestScore;
				}
			}
			//adds up the total scores excluding the first lowest score
			for(int i = 0; i < dummy.size(); i++){
				if(dummy.get(i).getScore()>lowestScore){
					total = total + dummy.get(i).getScore();
				}
				//if lowest score appears twice, we don't count the first instance
				else if(dummy.get(i).getScore()==lowestScore){
					lowestScore = lowestScore--;
				}
			}
			lowestScore = temp_lowest;
			size = (double)(dummy.size()-1);
			gbAverage = total/size;
			//change lowestScore in gbItems to gbCategory's average
			for(int i = 0; i < gbItems.size(); i++){
				if((gbItems.get(i).getGradebookCategory().getName().equals(gbCategoryName))
						&& (gbItems.get(i).getScore()==lowestScore)){
						gbItems.get(i).setScore(gbAverage);
						//only want to change 1 instance of lowest score
						lowestScore--;
				}
			}
		}
		//if gbCategory only contains 1 instance, the gbAverage is that score
		else if(dummy.size()==1){
			gbAverage = dummy.get(0).getScore();
		}
		average = average+(gbAverage*dummy.get(0).getGradebookCategory().getWeight());
		//clear dummy for next round
		while(!dummy.isEmpty()){
			dummy.remove(0);
		}
		total = 0;
	}
return average;
}	

public ArrayList<GradebookItem> getGBItems(){
	return gbItems;
}

}
