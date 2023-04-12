package POM;

import org.hamcrest.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Constants.constants;
import DriverManager.WebDriverManager;

public class MultipleDateTruTimePOM {

	@FindBy(xpath="(//span[@class='applyTopupPlus'])[1]")//1 is for multiple date '+' buton
	private static WebElement multipledateoptionbtn;
	
	@FindBy(xpath= "//input[@class='custom-text-input timePikcr1 timepicker form-control-text is-timeEntry']")
	private static WebElement Multipledatefromtime;
	
	@FindBy(xpath="//input[@class='custom-text-input timePikcr3 timepicker form-control-text is-timeEntry']")
	private static WebElement MultipleDateTotime;


    @FindBy(xpath="//button[@class='btn btn-secondary']")
    private static WebElement MultipleDateCancelbtn;
    
    @FindBy(xpath="//button[@class='btn btn-primary']")
    private static WebElement MultipleDateSubmitbtn;




	public static void MULTIPLEDATESELECTBTN(){

		//element intercepted exception occurrs so using js
		JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getDriver();
		js.executeScript("arguments[0].click();", multipledateoptionbtn);  
		//multipledateoptionbtn.click();
	}

	public static void Multipledateselection() {

		String a =	constants.STARTINGMULTIPLEDATE;
		int	i=Integer.parseInt(a);
		String b=	constants.ENDINGMULTIPLEDATE;
		int j = Integer.parseInt(b);

		for(int k=i ; k<=j ; k++) 
		{
			WebDriverManager.getDriver().findElement(By.xpath(
					"//td[@title='available']/a[contains(text(),"+k+")]")).click();
		}

	}
	
	public static void MULTIPLEDATEFROMTIME() {
		Multipledatefromtime.clear();
		Multipledatefromtime.sendKeys(constants.FROM_TIME);
	}
	
	public static void MULTIPLEDATETOTIME() {
		MultipleDateTotime.clear();
		MultipleDateTotime.sendKeys(constants.TO_TIME);	
	}
	
	public static void MULRIPLEDATESUBMIT() {
		MultipleDateSubmitbtn.click();
	}
	
	public static void MULTIPLEDATECANCEL() {
		MultipleDateCancelbtn.click();
	}

}
