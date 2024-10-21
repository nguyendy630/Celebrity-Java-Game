package src;
import java.util.ArrayList;

/**
 * The framework for the Celebrity Game project
 * 
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
    /**
     * The ArrayList of Celebrity values that make up the game
     */
    //A3 para 2 (page 7)
    private ArrayList<Celebrity> celebGameList = new ArrayList<Celebrity>();
    

    /**
     * A reference to a Celebrity or subclass instance.
     */

    private Celebrity gameCelebrity;

    //A3 para 3 (page 8)
    /**
     * 
     * The GUI frame for the Celebrity game.
     */
    //A3 para 5 (page 8)

    private CelebrityFrame gameWindow;

    /* 
    private String sport;
    private String country;
     */
    
    /**
     * Builds the game and starts the GUI
     */
    public CelebrityGame()
    {
        //A3 para 4 (page 8)
        celebGameList = new ArrayList<Celebrity>();
        gameWindow = new CelebrityFrame(this);
    }


    /**
     * Validates the name of the celebrity. It must have at least 4 characters.
     * @param name The name of the Celebrity
     * @return If the supplied Celebrity is valid
     */
    public boolean validateCelebrity(String name)
    {
        //A3 para 6 (page 9)
        if (name.trim().length() >= 4) 
        {
            return true;
        }

        
        return false;
    }

    /**
     * Checks that the supplied clue has at least 10 characters or is a series of clues
     * This method would be expanded based on your subclass of Celebrity.
     * @param clue The text of the clue(s)
     * @param type Supports a subclass of Celebrity 
     * @return If the clue is valid.
     */
    public boolean validateClue(String clue)
    {
        //A3 para 7 (page 9)

        if (clue.trim().length() >= 10) {
            return true;
        }
        
        
        return false;
    }

    public boolean validateSport(String sport, String type) {

        if (sport == null && type == "Celebrity"|| type == "Literature" && type != "Athlete") {

            return true;

        } else if (sport != null && sport.length() >= 4 && type == "Athlete") {

            return true;
        }



        return false;

    }

    public boolean validateCountry(String country, String type) {

        if (country == null && type == "Celebrity" || type == "Literature" && type != "Athlete") {

            return true;
        
        } else if (country != null && country.length() >= 4 && type == "Athlete") {

            return true;

        }


        return false;
    }


    /**
     * Adds a Celebrity of specified type to the game list
     * 
     * @param name
     *            The name of the celebrity
     * @param guess
     *            The clue(s) for the celebrity
     * @param type
     *            What type of celebrity
     */
    public void addCelebrity(String name, String guess, String type, String sport, String country)
    {
        //A3 para 8 (page 10)
        
        /* To be implemented */
        boolean isValidName = validateCelebrity(name);
        boolean isValidClue = validateClue(guess);

        if (type == "Celebrity") {
            if (isValidName && isValidClue) {
                Celebrity celeb = new Celebrity(name, guess);
                celebGameList.add(celeb);
            }
        } else if (type == "Literature") {
            if (isValidName && isValidClue) {
                LiteratureCelebrity celeb = new LiteratureCelebrity(name, guess);
                celebGameList.add(celeb);
            }
        } else if (type == "Athlete") {

            boolean isValidSport = validateSport(sport, type);
            boolean isValidCountry = validateCountry(country, type);

            if (isValidName && isValidClue && isValidCountry && isValidSport) {
                CelebrityAthlete celeb = new CelebrityAthlete(name, guess, sport, country);
                celebGameList.add(celeb);
            }

        }
     }
    

    /**
     * Asserts that the list is initialized and contains at least one Celebrity.
     * Sets the current celebrity as the first item in the list. Opens the game
     * play screen.
     */
    public void play()
    {
        //A3 para 8 (page 10)
        
        /* To be implemented */
        if (celebGameList != null && celebGameList.size() > 0) {
            this.gameCelebrity = celebGameList.get(0);
            gameWindow.replaceScreen("GAME");
        }
                
    }

    /**
     * Accessor method for the current size of the list of celebrities
     * 
     * @return Remaining number of celebrities
     */
    public int getCelebrityGameSize()
    {
        //A3 para 9 (page 11)
        return celebGameList.size();
    }

    /**
     * Determines if the supplied guess is correct.
     * 
     * @param guess
     *            The supplied String
     * @return Whether it matches regardless of case or extraneous external
     *         spaces.
     */

    public boolean processGuess(String guess)
    {
        //A3 para 10 (page 11)
        if (guess.trim().equalsIgnoreCase(gameCelebrity.getAnswer())) {
            
            celebGameList.remove(gameCelebrity);
            

            if (celebGameList.size() > 0) {
                gameCelebrity = celebGameList.get(0);

            } else {
                gameCelebrity = new Celebrity(" ", " ");
            }
            return true;
 
        }
        return false;
    }

    /**
     * Accessor method for the games clue to maintain low coupling between
     * classes
     * 
     * @return The String clue from the current celebrity.
     */
    public String sendClue()
    {
        //A3 para 11 (page 11)
        if (gameCelebrity != null) {

            return gameCelebrity.getClue();
        }
        return null;
    }

    public String sendSport() {
        
        if (gameCelebrity != null) {
            if (gameCelebrity instanceof CelebrityAthlete) {
                CelebrityAthlete athlete = (CelebrityAthlete) gameCelebrity;
                return athlete.getSport();
            }
        }

        return null;
    }

    public String sendCountry() { 
            if (gameCelebrity != null) {
                if (gameCelebrity instanceof CelebrityAthlete) {
                    CelebrityAthlete athlete = (CelebrityAthlete) gameCelebrity;
                    return athlete.getCountry();
                }
            }
    
            return null;
    }


    /**
     * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
     */
    public void prepareGame()
    {
        celebGameList = new ArrayList<Celebrity>();
        gameWindow.replaceScreen("START");
    }

    /**
     * Accessor method for the games answer to maintain low coupling between
     * classes
     * 
     * @return The String answer from the current celebrity.
     */
    public String sendAnswer()
    {
        return gameCelebrity.getAnswer();
    }

}
