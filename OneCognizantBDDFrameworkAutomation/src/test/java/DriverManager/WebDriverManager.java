package DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import Constants.constants;


public class WebDriverManager {

	public static WebDriver driver;


	public static void launchbrowser() {


		try {
			switch (constants.BROWSER) {
			case "chrome":
				io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "edge":
				io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
			case "firefox":
				io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();

			default:
				io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public static WebDriver getDriver() {
		return driver;
	}

}
