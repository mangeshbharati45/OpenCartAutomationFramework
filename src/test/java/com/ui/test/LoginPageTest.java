package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ui.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static com.ui.constants.AppConstants.*;

@Epic("Epic 100: design pages for open cart application")
@Feature("F 50: Open Cart - Login Feature")
@Story("US 101: implement login page for open cart application")
public class LoginPageTest extends BaseTest {
	
	@BeforeClass
	public void loginPageSetUp() {
		loginPage = homePage.goToLogin();
	}
	
	@Description("checking open cart login page url")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Mangesh")
	@Test(description = "Checking login Page Functionality")
	public void loginTest() {  
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), HOME_PAGE_TITLE);
	}

}
