package alerts;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;

import execution.DriverHandler;
import models.Browsers;
import models.Step;
import models.TestCase;

public class ValidateText extends TestCase {
	public ValidateText(Browsers browser) {
		this.browser = browser;
		this.name = "Validate message after handling alert";
	}
	
	private void navigate() throws Exception {
		driver.get(Elements.URL);
		Thread.sleep(1500);
		DriverHandler.scroll(0, 500);
	}
	
	private void clickBtn() throws Exception {
		driver.findElement(Elements.Button).click();
		Thread.sleep(2000);
	}
	
	private void AcceptAlert() throws Exception {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(1000);
		String text = driver.findElement(Elements.ConfirmMsg).getText();
		String expected = "You clicked OK, confirm returned true.";
		if(!expected.equals(text)) {
			String errorMsg = "Error: Text are not the same. \nExpected: %s \nFound: %s";
			throw new Exception(String.format(errorMsg, expected, text));
		}
	}
	
	private void DismissAlert() throws Exception {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
		Thread.sleep(1000);
		String text = driver.findElement(Elements.ConfirmMsg).getText();
		String expected = "You clicked Cancel, confirm returned false";
		if(!expected.equals(text)) {
			String errorMsg = "Error: Text are not the same. \nExpected: %s \nFound: %s";
			throw new Exception(String.format(errorMsg, expected, text));
		}
	}
	
	@Override
	public List<Step> getSteps(){
		Step nav = new Step() {
			public void executeStep() throws Exception {
				name = "navigate";
				navigate();
			}
		};
		Step clickBtn = new Step() {
			public void executeStep() throws Exception {
				name = "click Btn";
				clickBtn();
			}
		};
		Step accept = new Step() {
			public void executeStep() throws Exception {
				name = "AcceptAlert";
				AcceptAlert();
			}
		};
		Step dismiss = new Step() {
			public void executeStep() throws Exception {
				name = "DismissAlert";
				DismissAlert();
			}
		};
		
		return Arrays.asList(nav, clickBtn, accept, nav, clickBtn, dismiss);
	}
	
	
}
