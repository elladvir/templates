package giutests;

import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseGuiTest{

	@Test
	public static void searchOnGooglePage(){
		browseToUrl("http://www.google.com");
	}
}
