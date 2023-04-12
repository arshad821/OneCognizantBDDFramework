package StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;

import Constants.constants;
import DriverManager.WebDriverManager;
import POM.CLPage_POM;
import POM.HomePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CL_SearchIOptionStepDef {

	@Given("user can again navigating again to home......")
	public void user_can_again_navigating_again_to_home() {
		try {
			//code written in CommonStep Definition
			WebDriverManager.getDriver().navigate().refresh();
			WebDriverManager.driver.manage().window().maximize();


		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
		}
	}

	@When("user again searching Cognizant LEARN and again select it")
	public void user_again_searching_cognizant_learn_and_again_select_it() {
		try {

			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			HomePage_POM.Searchbar_2();
			HomePage_POM.CognizantLearnAPP();
			WebDriverManager.driver.manage().window().maximize();
			Thread.sleep(20000); ;//timeouts not worked so used java sleep

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}
	}

	@When("user can now select dropdown and select required options")
	public void user_can_now_select_dropdown_and_select_required_options() {
		try {
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(1));

			CLPage_POM.LEARNING_DROPDOWN();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("user can select search_bar and type required details")
	public void user_can_select_search_bar_and_type_required_details() {
		try {
			CLPage_POM.SEARCH_BAR_CONTENT();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("user can now select required courses\\/video")
	public void user_can_now_select_required_courses_video() {
		try {
			if(constants.learning_dropdown.equalsIgnoreCase("Learning")) {
				WebDriverManager.driver.switchTo().frame("CoreIFrame");
				CLPage_POM.LEARNING_CONTENT_SELECT();
			}
			else if(constants.learning_dropdown.equalsIgnoreCase("KPoint Content")){
				WebDriverManager.driver.switchTo().frame("CoreIFrame");
				CLPage_POM.KP_CONTENT();
				Thread.sleep(10000);
			}
			else {
				WebDriverManager.driver.switchTo().frame("CoreIFrame");
				if(CLPage_POM.no_result.isDisplayed()) {
					System.out.println("No Results Found!!! Modify the search and Try Again");
					Thread.sleep(2000);
					WebDriverManager.driver.close();
				}}
		} catch (Exception e) {

		}
	}

	@Then("user can now see the course_details and capture if need")
	public void user_can_now_see_the_course_details_and_capture_if_need() {
		try {
			if(constants.learning_dropdown.equalsIgnoreCase("Learning")) {
				Thread.sleep(4000);
				System.out.println("Courses in Learning Dropdown has been seeen and captured!!");
			}
			else if(constants.learning_dropdown.equalsIgnoreCase("KPoint Content")){
				Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
				List<String> Windowslist = new ArrayList<String>(windows);
				WebDriverManager.getDriver().switchTo().window(Windowslist.get(2));
				System.out.println("Control Moved to KP point window and details captured!");
			}

		} catch (Exception e) {

		}
	}


}
