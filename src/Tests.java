import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;


public class Tests {	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@org.junit.Test
	public void testForURL() {
		
		//these tests should evaluate to true, false, equal ========================
		assertTrue(URLProcessing.checkUrl("http://google.com"));
		assertFalse(URLProcessing.checkUrl("http://gog.commss"));
		assertEquals(true, URLProcessing.checkUrl("http://google.com"));
	}

}
