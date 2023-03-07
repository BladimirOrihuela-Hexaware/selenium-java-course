package models;

import execution.Execution;

public class TestSet {
	
	private TestCase[] tests;
	
	public TestSet(TestCase... tests) throws Exception {
		if(tests.length == 0) throw new Exception("Invalid parameter");
		this.tests = tests;
	}
	
	public void run() throws Exception {
		if(this.tests == null) throw new Exception("tests are null");
		if(this.tests.length == 0) throw new Exception("no tests defined");
		
		new Execution(this.tests);
	}

}
