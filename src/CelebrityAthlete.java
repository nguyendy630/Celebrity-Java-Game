package src;
import java.util.ArrayList;


public class CelebrityAthlete extends Celebrity {

     // Instance Variables
     private String country;
     private String sport;
     private ArrayList<String> athleteClueList = new ArrayList<String>();
     // End of Instance Variables

     public CelebrityAthlete(String answer, String clue, String sport, String country) {
          super(answer, clue);
          this.sport = sport;
          this.country = country;
          processAthleteClues(); 
     }
 

     private void processAthleteClues()
	{
		String [] clues = super.getClue().split(",");
		athleteClueList = new ArrayList<String>();
		for (String currentClue : clues)
		{
			athleteClueList.add(currentClue);
		}
	}
     
     public String getSport() {
          return this.sport;
     }

     public String getCountry() {
          return this.country;
     }

     @Override
	public String getClue()
	{
		if (athleteClueList.size() == 0)
		{
			processAthleteClues();
		}
		String currentClue = athleteClueList.remove(0);
		
		return currentClue;
	}


     @Override
     public String toString() {
          return "The Athlete Celebrity is + " + getAnswer()+ " and clue is " + getSport() + " " + getCountry();
     }
}