package main;

import Google.SearchHexaware;
import models.Browsers;
import models.TestCase;
import models.TestSet;

public class Pipeline {

	public static void main(String[] args) {
		TestCase searchHexaChrome = new SearchHexaware(Browsers.Chrome);
		TestCase searchHexaFirefox = new SearchHexaware(Browsers.Firefox);
		
		try {
			new TestSet(searchHexaChrome, searchHexaFirefox).run();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
