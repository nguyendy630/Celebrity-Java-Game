package src;
import java.awt.CardLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GUI Frame class for the Celebrity Game
 * @author cody.henrichsen
 * @version 2.1 17/09/2018
 */
public class CelebrityFrame extends JFrame
{
	//Data members for the JFrame subclass instance 
	
	/**
	 * The instance of the panel used for playing the game.
	 */
	private CelebrityPanel gamePanel;
	
	/**
	 * Blank panel used for the CardLayout switching screens feature.
	 */
	private JPanel panelCards;
	
	/**
	 * The instance variable used to add a celebrity to the game.
	 */
	private StartPanel startPanel;
	
	/**
	 * A reference to the CelebrityGame instance to allow for minimized coupling in the object structure.
	 */
	private CelebrityGame controller;

	private CardLayout cardLayout;
	
	
	/**
	 * Builds an instance of the CelebFrame with a reference to the CelebrityGame instance.
	 * @param controller A reference to a CelebrityGame to share with the CelebPanel instance.
	 */
	public CelebrityFrame(CelebrityGame controllerRef)
	{
		//The first line of any subclass should ALWAYS be a correct call to the super constructor.
		super();
		controller = controllerRef;
		startPanel = new StartPanel(controllerRef);
		gamePanel = new CelebrityPanel(controllerRef);	

		cardLayout =  new CardLayout();
		panelCards = (JPanel) this.getContentPane();
		panelCards.setLayout(cardLayout);
		

		setupFrame();
	
	}
	
	/**
	 * Configures the JFrame window subclass to add the panel and set size based information.
	 */
	private void setupFrame()
	{
		startPanel = new StartPanel(controller);
		gamePanel =  new CelebrityPanel(controller);
		setSize(500, 500);
		setVisible(true);
	}
	
	/**
	 * Swaps the screen between the existing panels based on the String parameter.
	 * @param screen The name of the screen to open.
	 */
	public void replaceScreen(String screen)
	{
		cardLayout.show(panelCards, screen);

		if (screen.equals("GAME")) {
			remove(startPanel);
			add(gamePanel);
			gamePanel.addClue(controller.sendClue());

		} else if (screen.equals("START")) {
			super.remove(gamePanel);
			add(startPanel);
		}
	}
	
}
