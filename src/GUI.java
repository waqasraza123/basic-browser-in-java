import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.eclipse.swt.internal.win32.GUITHREADINFO;

public class GUI extends JFrame{
	//class level variables ====================
	public static JTextField searchBar;
	public static JEditorPane displayArea;
	static JButton searchButton;
	static JPanel displayPanel;
	static JPanel searchPanel;
	static JButton goBackButton, goForwardButton, reloadButton;
	static JButton newTabButton;
	static JButton screenShotButton;
	static JFrame frame;
	static JPanel tabsPanel;
	static JButton tabsButton;
	static int tabsCounter;
	String title = "Thunder Bolt";
	
	//default constructor ===============================
	public GUI() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		
		//set frame properties =====================
		frame = new JFrame();
		frame.setTitle(title); // "this" Frame sets title
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);     // "this" Frame sets initial siz
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public GUI(String name){
		
	}
	
	public void doEverything() {
		
		System.out.println("NT Ref got pressed");
		
		//initialize components =====================
		searchBar = new JTextField("Enter Url...", 100);
		displayArea = new JEditorPane(){
			public boolean getScrollableTracksViewportWidth() {
		        return true;
		        }
			};
		
		searchButton = new JButton("Search");
		displayPanel = new JPanel();
		searchPanel = new JPanel();
		tabsPanel = new JPanel();
		tabsButton = new JButton("1");
		goBackButton = new JButton();
		goForwardButton = new JButton();
		reloadButton = new JButton();
		newTabButton = new JButton("+");
		screenShotButton = new JButton("screenshot");
		
		//set images on buttons ======================
		setImagesOnButtons();
		
		
		//tooltips ========================================
		goBackButton.setToolTipText("go back");
		goForwardButton.setToolTipText("go forward");
		reloadButton.setToolTipText("Reload Page");
		newTabButton.setToolTipText("new tab");
		
		
		//editor pane properties =====================
		displayArea.setEditable(false);
		displayArea.setMaximumSize(new Dimension(10000, 100));
		displayArea.setPreferredSize(new Dimension(1300, 650));
		displayArea.setMinimumSize(new Dimension(1, 100));
		
		//add to the panels ==============
		displayPanel.add(new JScrollPane(displayArea));
		searchPanel.add(goBackButton);
		searchPanel.add(goForwardButton);
		searchPanel.add(reloadButton);
		searchPanel.add(searchBar);
		searchPanel.add(newTabButton);
		searchPanel.add(searchButton);
		searchPanel.add(screenShotButton);
		tabsPanel.add(tabsButton);
		
		
		frame.setLayout(new BorderLayout());
		//add components to the JFrame =============
		frame.add(displayPanel, BorderLayout.CENTER);
		frame.add(searchPanel, BorderLayout.NORTH);
		frame.add(tabsPanel, BorderLayout.LINE_START);
		
		frame.setVisible(true);
		
	}//do everything ends here

	//call url processing when search button is pressed
	void buttonPressed(){
		frame.setTitle(title + " : Loading....");
		searchButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new URLProcessing();
				System.out.println("I got pressed");
			}
		});
		frame.setTitle(title);
	}
	
	//take screenshot when corresponding button is pressed=============================
	void screenshotButtonPressed(){
		frame.setTitle(title + " : Taking Screenshot");
		screenShotButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("SC got pressed");
				try {
					ScreenShot.takeScreenshot("screenshot.png");
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.setTitle(title);
	}
	
	//funciton to set images on 
	//back, forward and reload buttons =================================================
	void setImagesOnButtons(){
		
		try {
			
		    Image img = ImageIO.read(getClass().getResource("left.png"));
		    goBackButton.setIcon(new ImageIcon(img));
		    
		    img = ImageIO.read(getClass().getResource("right.png"));
		    goForwardButton.setIcon(new ImageIcon(img));
		    
		    img = ImageIO.read(getClass().getResource("refresh.png"));
		    reloadButton.setIcon(new ImageIcon(img));
		    
		  } catch (IOException ex) {
		  }
	}
	
	//open a new tab ====================================================================
	void openNewTabButtonPressed(){
		frame.setTitle(title+" : Opening new tab");
		newTabButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("NT got pressed");
				++tabsCounter;
				(new EventHandler()).start();
				
			}
		});
	}
	
	//reload tab ===========================================
	void reloadButtonPressed(){
		frame.setTitle(title + " : Reloading");
		reloadButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new URLProcessing();				
			}
		});
		
		frame.setTitle(title);
	}
}
