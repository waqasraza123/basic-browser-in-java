import java.io.IOException;

import javax.swing.UnsupportedLookAndFeelException;

public class EventHandler extends Thread{

	static GUI gui = new GUI("test");
	private static int tabsCounter;
	
	public static void openNewTab(int counter) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, UnsupportedLookAndFeelException{
		tabsCounter = counter;
		gui.doEverything();
		//JButton tabsButton = new JButton(""+tabsCounter);
		//GUI.tabsPanel.add(tabsButton);		
	}

	public void run() {
		
		System.out.println("Thread " + GUI.tabsCounter + "running");
		
		try {
			openNewTab(GUI.tabsCounter);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
