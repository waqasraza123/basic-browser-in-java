import java.io.BufferedReader;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import org.apache.commons.validator.routines.UrlValidator;
public class URLProcessing {

	static String responseMessage;
	static int responseCode;
	HttpURLConnection connection;
	boolean validUrl = false;
	static UrlValidator urlValidator;
	String responseContent = "";
    String current;
    static URL url;
	
	//default constructor ==================
	public URLProcessing(){
		System.out.println(GUI.searchBar.getText());
		try
	    {
			//check if the url is valid ===========================
			validUrl = checkUrl(GUI.searchBar.getText());
			
			if(validUrl){
				//then open the connection =============================
		       url = new URL(GUI.searchBar.getText());
		       URLConnection urlConnection = url.openConnection();
		       connection = null;
		       if(urlConnection instanceof HttpURLConnection)
		       {
		          connection = (HttpURLConnection) urlConnection;
		       }
		       else
		       {
		          GUI.displayArea.setText("Enter an http url...");
		          return;
		       }
		       BufferedReader in = new BufferedReader(
		       new InputStreamReader(connection.getInputStream()));
		       
		       //read the data from response code ===================
		       while((current = in.readLine()) != null)
		       {
		    	   responseContent += current;
		       }
		     //set the content on screen ==========================
		       GUI.displayArea.setPage(GUI.searchBar.getText());
		       /*GUI.displayArea.setPage(url);
		       System.out.println(responseContent);
		       GUI.displayArea.setContentType("text/html");*/
		       
			}
			
			//if the url is invalid 
			else{
				GUI.displayArea.setText("Enter a valid url");
			}
			
	    }catch(IOException e)
	    {
	    	GUI.displayArea.setText("Unknown Host, Website does not Exist...");
	    	
	    }
	}
	
	//validates the url ==================================
	public static boolean checkUrl(String urlString) {
		urlValidator = new UrlValidator();
		
		if (urlValidator.isValid(urlString)) {
			return true;
		}
		
		else
			return false;		
	}
	
}
