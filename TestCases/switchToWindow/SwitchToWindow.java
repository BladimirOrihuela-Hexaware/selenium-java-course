package switchToWindow;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import models.Browsers;
import models.Step;
import models.TestCase;

public class SwitchToWindow extends TestCase {
	public SwitchToWindow(Browsers browser) {
		this.name = "Switch to a different window";
		this.browser = browser;
	}

	private void navigate() {
		driver.get(Elements.URL);
	}

	private void clickOnLink() {
		driver.findElement(Elements.Link).click();
	}

	private void switchToWindow() throws Exception {
		Thread.sleep(1000);

		Set<String> windows = driver.getWindowHandles();

		String currentWindow = driver.getWindowHandle();

		String targetWindow = "";
		for (String window : windows) {
			if (window != currentWindow) {
				targetWindow = window;
			}
		}

		WebDriver driver2 = driver.switchTo().window(targetWindow);

		// Maximize window
		driver2.manage().window().maximize();
		driver2.findElement(Elements.Categories);

		driver2.navigate().to("https://google.com");

	}

	@Override
	public List<Step> getSteps(){
		Step nav = new Step() {
			public void executeStep() throws Exception {
			name = "navigate";
			navigate();
			}
		};
		Step clickLink = new Step() {
			public void executeStep() throws Exception {
			name = "click on link";
			clickOnLink();
			}
		};
		Step switchWin = new Step() {
			public void executeStep() throws Exception {
			name = "switchToWindow";
			switchToWindow();
			}
		};
		
		return Arrays.asList(nav, clickLink, switchWin);
	}

}
