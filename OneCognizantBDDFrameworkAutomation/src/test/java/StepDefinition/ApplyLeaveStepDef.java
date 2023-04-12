package StepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import Constants.constants;
import DriverManager.WebDriverManager;
import POM.HomePage_POM;
import POM.LeavePage_POM;
import POM.LoginPage_POM;
import POM.LoginPage1;
import POM.TruTimePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ht.Le;

public class ApplyLeaveStepDef {

	@Given("User again refreshing the browser to go main page")
	public void user_again_refreshing_the_browser_to_go_main_page() throws InterruptedException {

		try {
			WebDriverManager.getDriver().navigate().refresh();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}

	@SuppressWarnings("deprecation")
	@When("User is navigating to TruTime and selecting it")
	public void user_is_navigating_to_tru_time_and_selecting_it() {

		try {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverManager.getDriver().manage().window().maximize();
			HomePage_POM.SEARCHBAR();
			HomePage_POM.TruTIMEAPP();
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			WebDriverManager.getDriver().switchTo().frame("appFrame");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}

	@SuppressWarnings("deprecation")
	@When("User is clicking  Apply Leave Option and new window is opening")
	public void user_is_clicking_apply_leave_option_and_new_window_is_opening() {
		
		try {
			TruTimePage_POM.APPLYLEAVEBTN();
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(1));
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//System.out.println(WebDriverManager.getDriver().getCurrentUrl()); just for checking
			//LeavePage_POM.LeaveApplyPage();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}

	@When("after switching to new window user is selecting date to apply leave")
	public void after_switching_to_new_window_user_is_selecting_date_to_apply_leave() throws InterruptedException {
		
		try {
			Thread.sleep(1000);
			LeavePage_POM.LEAVESTARTDATE();
			Thread.sleep(2000);
			LeavePage_POM.ABSENCETYPE();
			Thread.sleep(2000);
			LeavePage_POM.LEAVEENDDATE();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("user is selecting type of leave and adding comments")
	public void user_is_selecting_type_of_leave_and_adding_comments() throws InterruptedException {

		try {
			LeavePage_POM.CALCDURTAIONBTN();
			Thread.sleep(3000);
			LeavePage_POM.TYPECOMMENTS();
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Then("user can now able to save|submit the leave request")
	public void user_can_now_able_to_save_submit_the_leave_request() throws IOException, InterruptedException {
		
		try {
			LeavePage_POM.SAVELATER();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
