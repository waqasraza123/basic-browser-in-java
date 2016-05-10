import java.io.IOException;

import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ClassNotFoundException {

		GUI gui = new GUI();
		gui.doEverything();
		//when the search button is pressed
		gui.buttonPressed();
		gui.screenshotButtonPressed();
		gui.openNewTabButtonPressed();
		gui.reloadButtonPressed();
	}
}
