package logger;

import models.Browsers;
import models.Step;

public class Logger {
	
	public Logger() {}
	
	public void logName(String name, Browsers browser) {
		System.out.println("=============================================");
		if(name != null)
			System.out.println("Running Test: " + name + " in " + browser);
	}
	
	public void logStep(Step step, int index) {
		if(step.name != null)
			System.out.println("Step " + (index + 1) + ": " + step.name );
		if(step.description != null)
			System.out.println("Details: " + step.description);
	}
	
	public void endExecution(boolean success) {
		String status = success ? "Successfully" : "with error";
		String message = String.format("=================Finished status: %s===============", status);
		System.out.println(message);
	}

}
