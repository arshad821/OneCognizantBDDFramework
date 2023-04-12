package POM;

import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Constants.constants;
import DriverManager.WebDriverManager;

public class CLPage_POM {
	
	@FindBy(id="idTimeLineSlideout")
	public static WebElement header;
	
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root MuiButton-root')])[1]")
	public static WebElement SelfDropdown;
	
	@FindBy(xpath="//span[text()='Dashboards']")
	private static WebElement Dashboard_option;
	
	@FindBy(xpath="//span[text()='Location Calendar']")
	private static WebElement Location_option;
	
	@FindBy(xpath="(//button[@aria-label='My Profile']//span)[1]")
	private static WebElement profile_pic_btn;
	
	@FindBy(xpath="(//button[@role='none']//span)[2]")
	private static WebElement profile_details_btn;
	
	@FindBy(id="profileDetailsTitle")
	public static WebElement profile_header;
	
	@FindBy(xpath="//div[@role='button']")
	private static WebElement Learning_dropdown;
	
	@FindBy(id="enterpriseSearch")
	private static WebElement search_box;
	
	@FindBy(xpath="(//a[@class='h4'])[1]")
	private static WebElement learning_content;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
	private static WebElement kpcontent_start_btn;
	
	@FindBy(xpath="//div[text()='No Results']")
	public static WebElement no_result;
	
	
	public static void options() {
		
		WebDriverManager.driver.findElement(By.xpath("//p[text()='"+constants.options+"']")).click();
	}
	
	public static void SELF_DROPDOWN() throws InterruptedException {
		
		
		SelfDropdown.click();
		Thread.sleep(1000);
		Dashboard_option.click();
		Thread.sleep(1000);
		Location_option.click();
		Thread.sleep(1000);
	}
	
	public static void SELECT_LOCATION() {
		WebDriverManager.driver.findElement(By.xpath("//div[text()='"+constants.location+"']")).click();
	}
	
	public static void profile_picture() {
		profile_pic_btn.click();
		profile_details_btn.click();
	}
	
	public static void LEARNING_DROPDOWN() throws InterruptedException {
		//JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		//js.executeScript("arguments[0].click();", Learning_dropdown); 
		Learning_dropdown.click();
		Thread.sleep(1000);
		WebDriverManager.driver.findElement(By.xpath("//li[text()='"+constants.learning_dropdown+"']")).click();
	}
	
	public static void SEARCH_BAR_CONTENT() {
		search_box.sendKeys(constants.search_bar + Keys.ENTER);
	}
	
	public static void LEARNING_CONTENT_SELECT() {
		learning_content.click();
	}

	public static void KP_CONTENT() {
		kpcontent_start_btn.click();
	}
	
}
