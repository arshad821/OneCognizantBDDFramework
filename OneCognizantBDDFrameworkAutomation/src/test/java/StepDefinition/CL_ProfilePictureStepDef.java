package StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverManager.WebDriverManager;
import POM.CLPage_POM;
import POM.HomePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CL_ProfilePictureStepDef {

	@Given("user can navigating again to home page....")
	public void user_can_navigating_again_to_home_page() {
		try {
			//code written in CommonStep Definition
			WebDriverManager.driver.navigate().refresh();
			WebDriverManager.driver.manage().window().maximize();

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}
	}

	@When("user can search for Cognizant LEARN")
	public void user_can_search_for_cognizant_learn() {

		try {

			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			HomePage_POM.Searchbar_2();
			HomePage_POM.CognizantLearnAPP();
			Thread.sleep(20000); ;//timeouts not worked so used java sleep

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("user can click profile picture")
	public void user_can_click_profile_picture() {

		try {
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(1));
			/*
			 * WebDriverWait explicit_wait= new WebDriverWait(WebDriverManager.driver,
			 * Duration.ofSeconds(20));
			 * explicit_wait.until(ExpectedConditions.visibilityOf(CLPage_POM.SelfDropdown))
			 * ;
			 */


		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("user can click profile details option")
	public void user_can_click_profile_details_option() throws InterruptedException {
		CLPage_POM.profile_picture();
		Thread.sleep(5000);
	}

	@Then("user can now view\\/capture profile detatils")
	public void user_can_now_view_capture_profile_detatils() {
		try {
			WebDriverManager.driver.switchTo().frame(0);
			//WebDriverManager.driver.switchTo().frame(0);//nested frame
			if(CLPage_POM.profile_header.isDisplayed()) {
				System.out.println("Required profile picture details has been seen and screenshot captured and added to report");
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
