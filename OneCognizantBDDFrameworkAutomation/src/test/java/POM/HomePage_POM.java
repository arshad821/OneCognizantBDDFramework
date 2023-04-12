package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonUtils.CommonUtilities;
import Constants.constants;

public class HomePage_POM {
	
	@FindBy(xpath="//*[@id=\"DesktopPlatformBar\"]/nav/div/ul[2]/li")
	private static WebElement searchbtn;
	
	@FindBy(id="oneC_searchAutoComplete")
	private static WebElement searchbar;
	
	@FindBy(xpath="//div[@class='appsResultText'][normalize-space()='TruTime']")
	private static WebElement trutimeapp;
	
	@FindBy(xpath="//div[@aria-label='Cognizant LEARN Opens in a new tab']")
	private static WebElement cognizantlearnapp;
	

	
	public static void SEARCHBAR() {
		
		//searchbtn.click();
		CommonUtilities.getInstance().highlightingwebelement(searchbar);
		searchbar.sendKeys(constants.APP_NAME);
	}
	
	public static void Searchbar_2() {
		CommonUtilities.getInstance().highlightingwebelement(searchbar);
		searchbar.sendKeys(constants.App_Name_2);
	}
	
	public static void TruTIMEAPP() {
		trutimeapp.click();
	}
	
	public static void CognizantLearnAPP() {
		cognizantlearnapp.click();
	}
	
	
	
	
	

}
