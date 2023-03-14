package main;

import Google.SearchHexaware;
import alerts.ValidateText;
import dragAndDrop.DragAndDrop;
import form.FillForm;
import models.Browsers;
import models.TestCase;
import models.TestSet;
import switchToWindow.SwitchToWindow;

public class Pipeline {

	public static void main(String[] args) {
		
		TestCase validateAlerts = new FillForm(Browsers.Chrome);
		
		try {
//			new TestSet(searchHexaChrome, searchHexaEdge).run();
//			new TestSet(fillFormInChrome, fillFormInF).run();
			new TestSet(validateAlerts).run();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
