package form;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	private void checkBoxes() throws Exception {
		
		driver.findElement(Elements.Checkobox1).click();
		driver.findElement(Elements.Checkobox2).click();
	}
	
	private void selectAllOptions() throws Exception {
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
		Thread.sleep(5000);
	}
	
	private void clickSubmit() throws Exception {
		driver.findElement(Elements.Submit).click();
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
		
		return Arrays.asList(nav, inputs, checks, options, submit);
	}
	
}
