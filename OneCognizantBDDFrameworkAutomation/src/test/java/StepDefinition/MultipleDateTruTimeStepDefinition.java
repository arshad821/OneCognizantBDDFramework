package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import DriverManager.WebDriverManager;
import POM.HomePage_POM;
import POM.MultipleDateTruTimePOM;
import POM.TruTimePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleDateTruTimeStepDefinition {


	@Given("user is again navigating back to main page")
	public void user_is_again_navigating_back_to_main_page() throws InterruptedException {
		
		try {
			WebDriverManager.getDriver().navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

	@SuppressWarnings("deprecation")
	@When("user again searching for TruTime and selecting it")
	public void user_again_searching_for_tru_time_and_selecting_it() {

		try {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			HomePage_POM.SEARCHBAR();
			HomePage_POM.TruTIMEAPP();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		

	}

	@SuppressWarnings("deprecation")
	@When("user need to select multiple date topup")
	public void user_need_to_select_multiple_date_topup() throws InterruptedException {

		try {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebDriverManager.getDriver().switchTo().frame("appFrame");
			Thread.sleep(2000);
			MultipleDateTruTimePOM.MULTIPLEDATESELECTBTN();
			Thread.sleep(1000);
			MultipleDateTruTimePOM.Multipledateselection();
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}

	@When("user need to fill all topup details again")
	public void user_need_to_fill_all_topup_details_again() throws InterruptedException {
		try {
			MultipleDateTruTimePOM.MULTIPLEDATEFROMTIME();
			MultipleDateTruTimePOM.MULTIPLEDATETOTIME();
			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}

	@Then("user can able to submit\\/cancel it now")
	public void user_can_able_to_submit_cancel_it_now() {

		try {
			MultipleDateTruTimePOM.MULTIPLEDATECANCEL();
		//	MultipleDateTruTimePOM.MULTIPLEDATESELECTBTN()
		} catch (Exception e) {
			Assert.fail(e.getMessage());		
			}
		
	}

}
