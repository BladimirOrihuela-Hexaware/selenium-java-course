package execution;

import java.util.List;

import org.openqa.selenium.WebDriver;

import logger.Logger;
import models.Browsers;
import models.Step;
import models.TestCase;

public class Execution {
	
	private Logger log;
	
	public Execution(TestCase[] tests) {
		log = new Logger();
		executeTests(tests);
	}
	
	private void executeTests(TestCase[] tests) {
		for (TestCase testCase : tests) {
			run(testCase);
		}
	}
	
	private void run(TestCase test) {
		boolean success = true;
		Browsers browser = test.browser;
		
		DriverHandler.setSystemProperty(browser);
		WebDriver driver = DriverHandler.getDriver(browser);
		
		log.logName(test.name, browser);
		
		test.setDriver(driver);
		List<Step> steps = test.getSteps();
		
		
		for (int i = 0; i < steps.size(); i++) {
			Step step = steps.get(i);
			
			try {
				
				step.executeStep();
				log.logStep(step, i);
				
			} catch (Exception e) {
				success = false;
				System.out.println(e.getMessage());
			}
			
		}
		
		driver.quit();
		log.endExecution(success);
		
	}

}
