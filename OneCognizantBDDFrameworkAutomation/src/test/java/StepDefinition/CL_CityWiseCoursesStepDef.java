package StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constants.constants;
import DriverManager.WebDriverManager;
import POM.CLPage_POM;
import POM.HomePage_POM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CL_CityWiseCoursesStepDef {

	@Given("user can navigate back home page..")
	public void user_can_navigate_back_home_page() {
		try {
			//code written in CommonStep Definition
			WebDriverManager.driver.navigate().refresh();
			WebDriverManager.driver.manage().window().maximize();

		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}
	}

	@When("user can search for Cognizant LEARN and select it")
	public void user_can_search_for_cognizant_learn_and_select_it() {
		try {

			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			HomePage_POM.Searchbar_2();
			HomePage_POM.CognizantLearnAPP();
			Thread.sleep(20000); ;//timeouts not worked so used java sleep

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("user can select Self dropdown and select location calender")
	public void user_can_select_self_dropdown_and_select_location_calender() {
		try {
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(1));
			CLPage_POM.SELF_DROPDOWN();

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("user can now select required cities")
	public void user_can_now_select_required_cities() {
		try {
			Thread.sleep(8000);
			WebDriverManager.driver.switchTo().frame(0);
			WebDriverManager.driver.switchTo().frame(0);//nexted iframe
			List<WebElement> list_cities =	WebDriverManager.driver.findElements(By.className("cell_text"));
			//System.out.println(list_cities.size());	
			CLPage_POM.SELECT_LOCATION();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Then("user can now navigate to newlyopened window and capture the required informations.")
	public void user_can_now_navigate_to_newlyopened_window_and_capture_the_required_informations() {
		try {
			Set<String> windows =    WebDriverManager.getDriver().getWindowHandles();
			List<String> Windowslist = new ArrayList<String>(windows);
			WebDriverManager.getDriver().switchTo().window(Windowslist.get(2));
			WebElement final_city =	WebDriverManager.driver.findElement(By.
					xpath("//span[text()='Future Scheduled Classes - "+constants.location+"']"));
			if(final_city.isDisplayed()) {
				System.out.println("Required iformation has been seen and screenshot captured and added to report");

			}
			else {
				System.out.println("Scenario Failed!!! Modify and Run Again");
			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
