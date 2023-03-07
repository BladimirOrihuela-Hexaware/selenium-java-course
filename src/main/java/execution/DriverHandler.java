package execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import models.Browsers;

public class DriverHandler {

	public DriverHandler() {
	}
	
	public static WebDriver getDriver(Browsers browser) {
		switch(browser) {
		case Chrome:
			return new ChromeDriver();
		case Firefox:
			return new FirefoxDriver();
		case Edge:
			return new EdgeDriver();
		default:
			return new ChromeDriver();
		}
	}

	public static void setSystemProperty(Browsers browser) {
		String property, path;

		switch (browser) {
		case Chrome:
			property = "webdriver.chrome.driver";
			path = "C:\\Users\\2000086360\\Documents\\Cursos\\Selenium\\drivers\\chromedriver.exe";
			break;
		case Firefox:
			property = "webdriver.gecko.driver";
			path = "C:\\Users\\2000086360\\Documents\\Cursos\\Selenium\\drivers\\geckodriver.exe";
			break;
		case Edge:
			property = "webdriver.msedge.driver";
			path = "C:\\Users\\2000086360\\Documents\\Cursos\\Selenium\\drivers\\msedgedriver.exe";
			break;
		default:
			property = "webdriver.chrome.driver";
			path = "C:\\Users\\2000086360\\Documents\\Cursos\\Selenium\\drivers\\chromedriver.exe";
			break;
		}
		System.setProperty(property, path);
	}

}
