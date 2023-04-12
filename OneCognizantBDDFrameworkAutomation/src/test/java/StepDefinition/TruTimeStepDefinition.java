package StepDefinition;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.constants;
import DriverManager.WebDriverManager;
import POM.HomePage_POM;
import POM.LoginPage_POM;
import POM.LoginPage1;
import POM.TruTimePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TruTimeStepDefinition {


	@Given("^user can navigate to onecognizant\\.com in browser$")
	public void user_can_navigate_to_onecognizant_com_in_browser() throws Throwable {

		try {
			//code written in CommonStep Definition
			WebDriverManager.getDriver().navigate().refresh();

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
		}
	}

	@When("^user need to search for TruTime and select it$")
	public void user_need_to_search_for_TruTime_and_select_it() throws Throwable {

		try {

			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverManager.getDriver().manage().window().maximize();
			HomePage_POM.SEARCHBAR();
			HomePage_POM.TruTIMEAPP();
		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}

	}

	@SuppressWarnings("deprecation")
	@When("^user need to select particular date$")
	public void user_need_to_select_particular_date() throws Throwable {

		try {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			WebDriverManager.getDriver().switchTo().frame("appFrame");
			TruTimePage_POM.SELECTDATE();

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}

	}

	@When("^user need to fill all topup details$")
	public void user_need_to_fill_all_topup_details() throws Throwable {

		try {

			TruTimePage_POM.APPLYTOPUPBTN();
			TruTimePage_POM.SELECTREASON();
			Thread.sleep(3000);
			TruTimePage_POM.FROMTIME();
			TruTimePage_POM.TOTIME();
			Thread.sleep(4000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@Then("^user should able to submit it now$")
	public void user_should_able_to_submit_it_now() throws Throwable {

		try {
			TruTimePage_POM.CANCELBUTTON();
			//TruTimePage_POM.SUBMITBUTTON();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}


	}
}
