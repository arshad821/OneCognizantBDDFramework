package StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.WebDriverManager;
import POM.CLPage_POM;
import POM.HomePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CL_timelineOptionStepDef {

	@Given("user is navigating to onecognizant.com in browser")
	public void user_is_navigating_to_onecognizant_com_in_browser() {

		try {
			//code written in CommonStep Definition
			WebDriverManager.getDriver().navigate().refresh();
			WebDriverManager.driver.manage().window().maximize();

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
		}
	}
	@SuppressWarnings("deprecation")
	@When("user need to search for Cognizant LEARN and select it")
	public void user_need_to_search_for_cognizant_learn_and_select_it() {
		try {

			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			HomePage_POM.Searchbar_2();
			HomePage_POM.CognizantLearnAPP();
			Thread.sleep(20000); ;//timeouts not worked so used java sleep

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}
	}

	
	@When("user can  select timeline\\/library options now")
	public void user_can_select_timeline_library_options_now() {

		try {
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			//	System.out.println(Windowslist.size()); //checking
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(1));
			CLPage_POM.options();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}


	}

	@Then("user can now see all the required details")
	public void user_can_now_see_all_the_required_details() {
		try {
			WebDriverManager.driver.switchTo().frame(0);
			
			if(CLPage_POM.header.isDisplayed()) {
				System.out.println("Required iformation has been seen and screenshot captured and added to report");
				Thread.sleep(2000);
			}
			else {
				System.out.println("Scenario Failed!!! Modify and Run Again");
			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
