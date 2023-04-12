package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonUtils.CommonUtilities;
import Constants.constants;
import DriverManager.WebDriverManager;

public class LoginPage_POM {
	
	@FindBy(id="i0116")
	private static WebElement usernamebox;
	
	@FindBy(id="idSIButton9")
	private static WebElement usernamenextbutton;
	
	@FindBy(id="i0118")
	private static WebElement passwordbox;
	
	@FindBy(id="idSIButton9")
	private static WebElement signinbtn;
	
	@FindBy(xpath="(//div[@data-bind='text: display'])[4]")
	private static WebElement call_btn;
	
	@FindBy(id="signInAnotherWay")
	private static WebElement sign_anotherway;
	
	
	
	public static void USERNAMEDETAILS() throws InterruptedException {
		
		CommonUtilities.getInstance().highlightingwebelement(usernamebox);
		usernamebox.sendKeys(constants.USERNAME);
		Thread.sleep(1000);
		usernamenextbutton.click();
	}
	
	
	
	public static void PASSWORDDETAILS() throws InterruptedException {
		
		CommonUtilities.getInstance().highlightingwebelement(passwordbox);
		passwordbox.sendKeys(constants.PASSWORD);
		Thread.sleep(5000);
		signinbtn.click();
	}
	
	public static void sign_in_Another_Way() {
		sign_anotherway.click();
	}
	
	
	
	public static void Call_butn() {
		call_btn.click();
	}
	
	

}
