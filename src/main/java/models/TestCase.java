package models;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;

import execution.DriverHandler;

public class TestCase implements ITestCase {
	
	public WebDriver driver;
	public String name;
	public Browsers browser;
	public DriverHandler driverHandler;
	
	public TestCase isRemote() {
		DriverHandler.remote = true;
		return this;
	}

	public List<Step> getSteps() {
		return Arrays.asList();
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		driverHandler = new DriverHandler(driver);
	}
	
}
