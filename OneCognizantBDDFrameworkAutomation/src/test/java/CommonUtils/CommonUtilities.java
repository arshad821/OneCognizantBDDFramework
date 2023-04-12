package CommonUtils;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



import CommonUtils.CommonUtilities;
import Constants.constants;
import DriverManager.WebDriverManager;
import POM.CLPage_POM;
import POM.HomePage_POM;
import POM.LeavePage_POM;
import POM.LoginPage_POM;
import POM.LoginPage1;
import POM.MultipleDateTruTimePOM;
import POM.TruTimePage_POM;


public class CommonUtilities {

	private static CommonUtilities commonutilInstance;

	public CommonUtilities() {

	}

	public static CommonUtilities getInstance() {

		if(commonutilInstance==null) {
			commonutilInstance=new CommonUtilities();
		}

		return commonutilInstance;

	}

	public void loadproperties() {



		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/Config.properties"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		constants.BROWSER=properties.getProperty("BROWSER");
		constants.APP_URL=properties.getProperty("APP_URL");
		constants.USERNAME=properties.getProperty("USERNAME");
		constants.PASSWORD=properties.getProperty("PASSWORD");
		constants.APP_NAME=	properties.getProperty("APP_NAME");
		constants.App_Name_2=properties.getProperty("APP_NAME2");
		constants.SELECT_DATE=	properties.getProperty("SELECT_DATE");
		constants.TOP_UP_BUTTON=	properties.getProperty("TOP_UP_BUTTON");
		constants.SELECT_REASON=properties.getProperty("SELECT_REASON");
		constants.FROM_TIME=properties.getProperty("FROM_TIME");
		constants.TO_TIME=properties.getProperty("TO_TIME");
		constants.RECALL_DATE=properties.getProperty("RECALL_DATE");
		constants.RECALL_TOP_UP_BUTTON=properties.getProperty("RECALL_TOP_UP_BUTTON");
		constants.STARTINGMULTIPLEDATE=properties.getProperty("STARTMULTIPLEDATE");
		constants.ENDINGMULTIPLEDATE=properties.getProperty("ENDMULTIPLEDATE");
		constants.LEAVESTARTDATE=properties.getProperty("LEAVESTARTDATE");
		constants.LEAVEENDDATE=properties.getProperty("LEAVEENDDATE");
		constants.LEAVETYPE=properties.getProperty("LEAVETYPE");
		constants.COMMENTS=properties.getProperty("COMMENTS");
		
		constants.options=properties.getProperty("option");
		constants.location=properties.getProperty("CALENDER_LOCATION");
		constants.learning_dropdown=properties.getProperty("LEARNING_DROPDOWN");
		constants.search_bar=properties.getProperty("SEARCH_BAR_WORDINGS");


	}

	public void initWebelements() {

		PageFactory.initElements(WebDriverManager.getDriver(),LoginPage_POM.class);
		PageFactory.initElements(WebDriverManager.getDriver(),LoginPage1.class);
		PageFactory.initElements(WebDriverManager.getDriver(), HomePage_POM.class);
		PageFactory.initElements(WebDriverManager.getDriver(), TruTimePage_POM.class);
		PageFactory.initElements(WebDriverManager.getDriver(), MultipleDateTruTimePOM.class);
		PageFactory.initElements(WebDriverManager.getDriver(), LeavePage_POM.class);
		PageFactory.initElements(WebDriverManager.getDriver(), CLPage_POM.class);
	
	}
	
	public void highlightingwebelement(WebElement element) {
		
		JavascriptExecutor executor = (JavascriptExecutor) WebDriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style', 'border : 5px solid red')", element);
	}
	
	

}
