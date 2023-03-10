package execution;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import models.Browsers;

public class DriverHandler {
	
	public static WebDriver driver;
	public static Browsers browser;
	public static boolean remote;

	public DriverHandler(WebDriver _driver) {
		driver = _driver;
		remote = false;
	}
	
	private static WebDriver startRemoteDriver(MutableCapabilities options) {
		try {
			return new RemoteWebDriver(new URL("http://localhost:4444") , options);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
			return null;
		}
	}
	
	public static WebDriver getDriver(Browsers _browser) {
		
		browser = _browser;		
		
		switch(_browser) {
		case Chrome:
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			//chromeOptions.addArguments("--window-size=360,780");
//			chromeOptions.addArguments("headless"); 
			if(remote)
				return startRemoteDriver(chromeOptions);
			return new ChromeDriver(chromeOptions);
		case Firefox:
			FirefoxOptions fireOption = new FirefoxOptions();
			//fireOption.addArguments("--width=360", "--height=780");
			if(remote)
				return startRemoteDriver(fireOption);
			return new FirefoxDriver(fireOption);
		case Edge:
			return new EdgeDriver();
		default:
			return new ChromeDriver();
		}
	}
	
	public static void scroll(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(String.format("window.scrollBy(%s, %s)", x, y));
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
	
	public static void hightlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.outline = '#f00 solid 5px'", element);
	}
	
	public static void takeScreenshot(String name) throws Exception {
		String folder = "C:\\Users\\2000086360\\Documents\\Cursos\\Selenium\\workspace\\selenium-course\\src\\main\\resources\\screenshots\\%s_%s.png";
		String path = String.format(folder, name, browser);
		
		TakesScreenshot screenshotDriver = (TakesScreenshot)driver;
		File ssFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(ssFile, new File(path));
	}
	

}
