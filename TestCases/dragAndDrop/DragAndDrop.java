package dragAndDrop;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import execution.DriverHandler;
import models.Browsers;
import models.Step;
import models.TestCase;

public class DragAndDrop extends TestCase {
	public DragAndDrop(Browsers browser) {
		this.browser = browser;
		this.name = "Drag and Drop elements";
	}
	
	
	private void navigate() {
		driver.get(Elements.URL);
	}
	
	private void dragElement() throws Exception {
		WebElement source = driver.findElement(Elements.Source1);
		WebElement target = driver.findElement(Elements.Target2);
		
		DriverHandler.hightlightElement(source);
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
		
		Thread.sleep(1000);
		DriverHandler.takeScreenshot("drag_by_element");		
	}
	
	private void dragElementWithCoordinates() throws Exception {
		WebElement source = driver.findElement(Elements.Source2);
		DriverHandler.hightlightElement(source);
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(source, -200, 200).perform();
		
		Thread.sleep(1000);
		DriverHandler.takeScreenshot("drag_by_coordinates");	
	}
	
	public List<Step> getSteps(){
		Step nav = new Step() {
			public void executeStep() throws Exception {
				name = "navigate";
				navigate();
			}
		};
		
		Step dragElement = new Step() {
			public void executeStep() throws Exception {
				name = "drag by elements";
				dragElement();
			}
		};
		Step dragByCoords = new Step() {
			public void executeStep() throws Exception {
				name = "drag by coordinates";
				dragElementWithCoordinates();
			}
		};
		
		return Arrays.asList(nav, dragElement, nav, dragByCoords);
	}
}
