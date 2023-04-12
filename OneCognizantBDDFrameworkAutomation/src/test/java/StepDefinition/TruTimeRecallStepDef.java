package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import DriverManager.WebDriverManager;
import POM.HomePage_POM;
import POM.TruTimePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TruTimeRecallStepDef {

	@Given("user is navigating back to main page")
	public void user_is_navigating_back_to_main_page() throws InterruptedException {

		try {
			WebDriverManager.getDriver().navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());		} 

	}

	@SuppressWarnings("deprecation")
	@When("user is searching for TruTime and selecting")
	public void user_is_searching_for_tru_time_and_selecting() {

		try {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			HomePage_POM.SEARCHBAR();
			HomePage_POM.TruTIMEAPP();
		} catch (Exception e) {
			Assert.fail(e.getMessage());		}

	}

	@SuppressWarnings("deprecation")
	@When("user need to select date which is alread filled")
	public void user_need_to_select_date_which_is_alread_filled() {
		
		try {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebDriverManager.getDriver().switchTo().frame("appFrame");
			TruTimePage_POM.RECALLSELECTDATE();
		} catch (Exception e) {
			Assert.fail(e.getMessage());		}
	}

	@Then("user can select recall option and submit it")
	public void user_can_select_recall_option_and_submit_it() throws InterruptedException {

		try {
			TruTimePage_POM.RECALLTOPUP();
			Thread.sleep(1000);
			TruTimePage_POM.CANCELBUTTON();
			Thread.sleep(2000);
			TruTimePage_POM.RECALLBTN();
			Thread.sleep(2000);
			TruTimePage_POM.HIDETOPUP();
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());		}
	}

}
