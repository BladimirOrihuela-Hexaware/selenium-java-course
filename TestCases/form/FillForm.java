package form;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import execution.DriverHandler;
import models.Browsers;
import models.Step;
import models.TestCase;

public class FillForm extends TestCase {
	public FillForm(Browsers browser) {
		this.name = "Fill form";
		this.browser = browser;
	}
	
	private void navigateToForm() throws Exception {
		driver.get(Elements.URL);
	}
	
	private void fillInputs() throws Exception {
		driver.findElement(Elements.UserNameXpath).sendKeys("Blad");
		driver.findElement(Elements.Password).sendKeys("secret");
		driver.findElement(Elements.Comments).sendKeys("This is a comment. Hello");
	}
	
	private void uploadAFile() {
		String path = "C:\\Users\\2000086360\\Documents\\uploadFile.txt";
		driver.findElement(Elements.UploadElement).sendKeys(path);
	}
	
	private void checkBoxes() throws Exception {
		DriverHandler.scroll(0, 500);
		driver.findElement(Elements.Checkobox1).click();
		driver.findElement(Elements.Checkobox2).click();
	}
	
	private void selectAllOptions() throws Exception {
		WebElement item1 = driver.findElement(Elements.Item1);
		WebElement item4 = driver.findElement(Elements.Item4);
		DriverHandler.hightlightElement(item1);
		DriverHandler.hightlightElement(item4);
		
		Thread.sleep(1500);
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(item4).moveToElement(item1).perform();
		Thread.sleep(1500);
	}
	
	private void selectAllOptions2() throws Exception {
		WebElement item1 = driver.findElement(Elements.Item1);
		WebElement item2 = driver.findElement(Elements.Item2);
		WebElement item3 = driver.findElement(Elements.Item3);
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL);
		actions.click(item1);
		actions.click(item2);
		actions.click(item3);
		actions.keyUp(Keys.CONTROL);
		
		actions.build().perform();
	}
	
	private void clickSubmit() throws Exception {
		
		//Hide submit button
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement submitBtn = driver.findElement(Elements.Submit);
		js.executeScript("arguments[0].style.display='none'", submitBtn);
		DriverHandler.takeScreenshot("submitBtn_hidden");
		
		//Click on hidden element
		js.executeScript("arguments[0].click()", submitBtn);
		Thread.sleep(3000);
	}
	
	@Override
	public List<Step> getSteps() {
		Step nav = new Step() {
			public void executeStep() throws Exception {
				name = "navigate to form";
				navigateToForm();
			}
		};
		
		Step inputs = new Step() {
			public void executeStep() throws Exception {
				name = "Fill the inputs";
				description = "Fill username, password and comments";
				fillInputs();
			}
		};
		
		Step upload = new Step() {
			public void executeStep() throws Exception {
				name = "upload a file";
				uploadAFile();
			}
		};
		
		Step checks = new Step() {
			public void executeStep() throws Exception {
				name = "Check checkboxes";
				description = "Check box 1 & 2";
				checkBoxes();
			}
		};
		
		Step options = new Step() {
			public void executeStep() throws Exception {
				name = "Select all options";
				selectAllOptions();
			}
		};
		
		Step submit = new Step() {
			public void executeStep() throws Exception {
				name = "Submit form";
				clickSubmit();
			}
		};
		
		return Arrays.asList(nav, inputs,upload, checks, options, submit);
	}
	
}
