import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ScreenShot {
	
	static void takeScreenshot(String outFileName) throws AWTException, IOException{
		// determine current screen size
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension screenSize = toolkit.getScreenSize();
				Rectangle screenRect = new Rectangle(screenSize);
				// create screen shot
				Robot robot = new Robot();
				BufferedImage image = robot.createScreenCapture(screenRect);
				// save captured image to PNG file
				ImageIO.write(image, "png", new File(outFileName));
				// give feedback
				System.out.println("Saved screen shot (" + image.getWidth() +
					" x " + image.getHeight() + " pixels) to file \"" +
					outFileName + "\".");
	}
}