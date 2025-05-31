package com.ui.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.ui.factory.DriverFactory;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.pages.ProductDetailsPage;
import com.ui.pages.RegisterPage;
import com.ui.pages.SearchPage;

//@Listeners(ChainTestListener.class)
public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected RegisterPage registerPage;
	protected MyAccountPage accPage;
	protected SearchPage searchPage;
	protected ProductDetailsPage productDetailsPage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		df = new DriverFactory();
		prop = df.initProperties();
		if(browserName != null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);
		
	}
	
	@AfterMethod
	public void AttachScreenshot(ITestResult result) {
		if(!result.isSuccess()) {
			 ChainTestListener.embed(DriverFactory.getScreenshotFile(), "image/png");
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();		
	}
	

}
