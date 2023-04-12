package POM;

import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import CommonUtils.CommonUtilities;
import Constants.constants;
import DriverManager.WebDriverManager;
import java.lang.*;

public class TruTimePage_POM {

	@FindBy(id="fromTime")
	private static WebElement fromtime;

	@FindBy(id="toTime")
	private static WebElement totime;

	@FindBy(xpath="//*[@id=\"mCSB_2_container\"]/div[11]/div[3]/button[2]")
	private static WebElement cancelbtn;

	@FindBy(xpath="//*[@id=\"mCSB_2_container\"]/div[11]/div[3]/button[1]")
	private static WebElement submitbtn;

	@FindBy(xpath="(//span[@class='actnButtn ng-scope']//input[@value='Recall'])[1]")//dynamic it will change//modify
	private static WebElement recallbtn;

	@FindBy(xpath="//span[@role='button'][normalize-space()='Hide TopUp Details']")
	private static WebElement hidetopup;

	@FindBy(className = "ApplyLeave")
	private static WebElement applyleavebtn;


	public static void SELECTDATE() {

		String entered_date =	constants.SELECT_DATE;
		WebElement selectdate =	WebDriverManager.
				driver.findElement(By.xpath("//span[normalize-space()='"+entered_date+"']"));
		selectdate.click();
	}

	public static void APPLYTOPUPBTN() {

		String selected_topup_btn= constants.TOP_UP_BUTTON;
		WebElement applytopupbtn =	WebDriverManager.
				driver.findElement(By.xpath("(//span[@class='applyTopupPlus'])["+selected_topup_btn+"]"));
		applytopupbtn.click();
	}

	public static void SELECTREASON() throws InterruptedException {


		String a =constants.SELECT_REASON;
		WebDriverManager.getDriver().findElement(By.xpath
				("//span[@id='reasn-button']")).click();
		Thread.sleep(2000);
		WebDriverManager.getDriver().findElement(By.xpath
				("//li[@class='ui-menu-item']/div[contains(text(),'"+a+"')]")).click();//since it is string so

	}

	public static void FROMTIME() {
		CommonUtilities.getInstance().highlightingwebelement(fromtime);
		fromtime.clear();
		fromtime.sendKeys(constants.FROM_TIME);
	}

	public static void TOTIME() {
		CommonUtilities.getInstance().highlightingwebelement(totime);
		totime.clear();
		totime.sendKeys(constants.TO_TIME);
	}

	public static void CANCELBUTTON() {

		//element not interacting exception
		JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		js.executeScript("arguments[0].click();", cancelbtn);
		//cancelbtn.click();
	}
	public static void SUBMITBUTTON() {

		JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		js.executeScript("arguments[0].click();", submitbtn);
		//submitbtn.click();
	}


	public static void RECALLSELECTDATE() {

		String entered_recall_date= constants.RECALL_DATE;
		WebElement recallselectdate=WebDriverManager.driver.findElement(By.xpath("//span[normalize-space()='"+entered_recall_date+"']"));
		recallselectdate.click();
	}

	public static void RECALLTOPUP() {
		
		String selected_recall_topup= constants.RECALL_TOP_UP_BUTTON;
		WebElement recallapplytopupbtn=WebDriverManager.
				driver.findElement(By.xpath("(//span[@class='applyTopupPlus'])["+selected_recall_topup+"]"));
		CommonUtilities.getInstance().highlightingwebelement(recallapplytopupbtn);
		
		JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		js.executeScript("arguments[0].click();", recallapplytopupbtn); 
	}

	public static void RECALLBTN() {
		CommonUtilities.getInstance().highlightingwebelement(recallbtn);
		JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		js.executeScript("arguments[0].click();", recallbtn); 

	}

	public static void HIDETOPUP() {
		//hidetopup.click();
		//element not interacting exception
		CommonUtilities.getInstance().highlightingwebelement(hidetopup);
		JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		js.executeScript("arguments[0].click();", hidetopup); 
	}


	public static void APPLYLEAVEBTN() {
		applyleavebtn.click();
	}
}



