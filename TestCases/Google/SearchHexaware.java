package Google;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execution.DriverHandler;
import models.Browsers;
import models.Step;
import models.TestCase;

public class SearchHexaware extends TestCase {
	
	public SearchHexaware(Browsers browser) {
		this.browser = browser;
		this.name = "Search Hexaware in google";
	}
	
	private void navigateToGoogle() throws Exception {
		driver.get("https://www.google.com");
	}
	
	private void writeHexawareAndSearch() throws Exception{
		WebElement element =  driver.findElement(Elements.SearchBox);
		element.sendKeys("Hexaware");
		
		DriverHandler.hightlightElement(element);
		
		DriverHandler.takeScreenshot("search box");
		element.sendKeys(Keys.ENTER);
	}
	
	private void waitUntilTitleIsHexaware() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.titleContains("Hexaware"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1000)");
		DriverHandler.takeScreenshot("moved");
	}
	
	@Override
	public List<Step> getSteps(){
		
		Step first = new Step() {
			public void executeStep() throws Exception{
				name = "navigate to google";
				navigateToGoogle();
			}
		};
		
		Step second = new Step() {
			public void executeStep() throws Exception{
				name = "write Hexaware And perform Search";
				writeHexawareAndSearch();
			}
		};
		
		Step third = new Step() {
			public void executeStep() throws Exception{
				name = "wait Until Title Is Hexaware";
				waitUntilTitleIsHexaware();
			}
		};
		
		return Arrays.asList(first, second, third);	
		
	}
	
	
	
}
