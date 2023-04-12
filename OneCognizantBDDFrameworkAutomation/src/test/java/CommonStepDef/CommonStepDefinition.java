package CommonStepDef;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import CommonUtils.CommonUtilities;
import Constants.constants;
import DriverManager.WebDriverManager;
import POM.LeavePage_POM;
import POM.LoginPage1;
import POM.LoginPage_POM;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class CommonStepDefinition {

	@Before
	public void beforescenario() {
		try {
			CommonUtilities cmnutils = new CommonUtilities();
			cmnutils.loadproperties();
			if(WebDriverManager.getDriver()==null) {
				WebDriverManager.launchbrowser();
				CommonUtilities.getInstance().initWebelements();
				Login_To_Cognizant();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@After
	public static void SCREENSHOTTAKEN(Scenario scenario) throws IOException, InterruptedException {
		
		System.out.println("Scenario tags: " + scenario.getSourceTagNames());//checking
		//WebElement popupbox	= WebDriverManager.getDriver().findElement(By.id("win0div#ICOK"));
		
		if (scenario.getSourceTagNames().contains("@ApplyLeave") && LeavePage_POM.popupbox.isDisplayed()) {
			Thread.sleep(2000);
			byte[] screenshot = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "final popup box displayed");
			System.out.println("Screen captured & added in report");
			WebDriverManager.getDriver().close();
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(0));
		}
		else if(scenario.getSourceTagNames().contains("@cognizantLearn")) {
			Thread.sleep(2000);
			byte[] screenshot = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "CAPTURED SNAPSHOTS");
			Thread.sleep(1000);
			System.out.println("Screen captured & added in report");
			//WebDriverManager.driver.close(); // not working properly
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(0));
		}
		/*
		 * else { byte[] screenshot = ((TakesScreenshot)
		 * WebDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		 * scenario.attach(screenshot, "image/png", "Scenario Failed Screenshot");
		 * System.out.println("Scenario Failed"); WebDriverManager.getDriver().quit(); }
		 */
	}

	public static void Login_To_Cognizant() throws InterruptedException {

		WebDriverManager.getDriver().get(constants.APP_URL);
		WebDriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		LoginPage_POM.USERNAMEDETAILS();
		LoginPage_POM.PASSWORDDETAILS();

		LoginPage_POM.sign_in_Another_Way();

		LoginPage_POM.Call_butn();
		Thread.sleep(25000);
		LoginPage1.YESBTN();
	}


}
