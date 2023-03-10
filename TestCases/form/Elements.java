package form;

import org.openqa.selenium.By;

public class Elements {

	public static String URL = "https://testpages.herokuapp.com/styled/basic-html-form-test.html";
	
	public static By UserName = By.name("username");
	public static By UserNameXpath = By.xpath("//input[@name=\"username\"]");
	public static By Password = By.name("password");
	public static By Comments = By.name("comments");
	public static By Checkobox1 = By.xpath("//input[@value=\"cb1\"]");
	public static By Checkobox2 = By.xpath("//input[@value=\"cb2\"]");
	
	public static By MultipleSelection = By.name("multipleselect[]");
	public static By Item1 = By.xpath("//option[@value=\"ms1\"]");
	public static By Item2 = By.xpath("//option[@value=\"ms2\"]");
	public static By Item3 = By.xpath("//option[@value=\"ms3\"]");
	public static By Item4 = By.xpath("//option[@value=\"ms4\"]");
	
	public static By UploadElement = By.xpath("//input[@name=\"filename\"]");
	public static By UploadElementByName = By.name("filename");
	
	
	public static By SelectionOptions = By.name("dropdown");
	public static By Submit = By.xpath("//input[@name=\"submitbutton\"][2]");
}
