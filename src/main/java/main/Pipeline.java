package main;

import Google.SearchHexaware;
import form.FillForm;
import models.Browsers;
import models.TestCase;
import models.TestSet;
import switchToWindow.SwitchToWindow;

public class Pipeline {

	public static void main(String[] args) {
//		TestCase searchHexaChrome = new SearchHexaware(Browsers.Chrome);
//		TestCase searchHexaFirefox = new SearchHexaware(Browsers.Firefox);
//		TestCase searchHexaEdge = new SearchHexaware(Browsers.Edge);
		
		
//		TestCase fillFormInChrome = new FillForm(Browsers.Chrome);
//		TestCase fillFormInF = new FillForm(Browsers.Firefox);
		
		
		TestCase SwitchWin = new SwitchToWindow(Browsers.Chrome);
		
		try {
//			new TestSet(searchHexaChrome, searchHexaEdge).run();
//			new TestSet(fillFormInChrome, fillFormInF).run();
			new TestSet(SwitchWin).run();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
