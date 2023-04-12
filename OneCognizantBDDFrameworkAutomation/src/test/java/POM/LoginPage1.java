package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage1 {
	
	@FindBy(id="idSIButton9")
	private static WebElement yesbutton;
	
	public static void YESBTN() {
		yesbutton.click();
	}
	
	

}
