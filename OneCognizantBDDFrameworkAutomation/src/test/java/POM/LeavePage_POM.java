package POM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.CommonUtilities;
import Constants.constants;
import DriverManager.WebDriverManager;
import io.cucumber.java.Scenario;

public class LeavePage_POM {

	@FindBy(id="win0div#ICOK")
	public static WebElement popupbox;

	@FindBy(xpath="//div[@id='win0divPTNUI_LAND_REC_GROUPLET$2']")
	private static WebElement manageabsence;

	@FindBy(xpath="//*[@id=\"CT_FLUNAV_TBL_TITLE$0\"]/span")
	private static WebElement Apply_scheduleleavebtn;

	@FindBy(id="DERIVED_ABS_SS_BGN_DT")
	private static WebElement leavestartdate;

	@FindBy(xpath="//*[@id='DERIVED_ABS_SS_PIN_TAKE_NUM']")
	private static WebElement AbsensceType;

	@FindBy(id="DERIVED_ABS_SS_END_DT")
	private static WebElement leaveenddate;

	@FindBy(id="DERIVED_ABS_SS_CALC_END_DT_BTN")
	private static WebElement calculateduration;

	@FindBy(xpath = "//textarea[@id='DERIVED_ABS_SS_COMMENTS']")
	private static WebElement TypeComments;

	@FindBy(xpath="//a[@id=\"DERIVED_ABS_SS_SAVE_BTN\"]")
	private static WebElement savelaterbuton;

	@FindBy(xpath = "win0div#ICOK")
	private static WebElement popbox;


	public static void LeaveApplyPage() {


		WebDriverWait explicitwait = new WebDriverWait(WebDriverManager.driver, Duration.ofSeconds(20));
		explicitwait.until(ExpectedConditions.visibilityOf(manageabsence));
		manageabsence.click();
		Apply_scheduleleavebtn.click();

	}

	public static void LEAVESTARTDATE() {
		leavestartdate.clear();
		leavestartdate.sendKeys(constants.LEAVESTARTDATE);
	}

	public static void ABSENCETYPE() throws InterruptedException {

		CommonUtilities.getInstance().highlightingwebelement(AbsensceType);
		AbsensceType.click();
		AbsensceType.sendKeys(constants.LEAVETYPE+Keys.ENTER);
		WebDriverManager.driver.navigate().refresh();
		try{
			AbsensceType.sendKeys(constants.LEAVETYPE);
		}
		catch(StaleElementReferenceException e){
			AbsensceType =WebDriverManager.driver.findElement(By.xpath("//*[@id='DERIVED_ABS_SS_PIN_TAKE_NUM']"));
			AbsensceType.sendKeys(constants.LEAVETYPE +Keys.ENTER);
		}	


	}

	public static void LEAVEENDDATE() {
		leaveenddate.clear();
		leaveenddate.sendKeys(constants.LEAVEENDDATE);

	}

	public static void CALCDURTAIONBTN() {
		calculateduration.click();
	}

	public static void TYPECOMMENTS() {
		CommonUtilities.getInstance().highlightingwebelement(TypeComments);
		TypeComments.sendKeys(constants.COMMENTS);
	}

	public static void SAVELATER() {
		savelaterbuton.click();
	}


}
