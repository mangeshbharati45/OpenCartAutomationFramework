package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ui.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import static com.ui.constants.AppConstants.*;

public class MyAccountPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		loginPage = homePage.goToLogin();
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("checking open cart Acc page title...")
	@Severity(SeverityLevel.MINOR)
	@Owner("Mangesh")
	@Test(description = "Checking Account Page Title")
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(), HOME_PAGE_TITLE );
	}
	
	@Description("checking open cart acc page headers...")
	@Severity(SeverityLevel.MINOR)
	@Owner("Mangesh")
	@Test(description = "Checking Account Page Headers")
	public void accPageHeadersTest() {
		Assert.assertEquals(accPage.getAccountPageHeaders(), expectedAccountPageHeaders);
	}

}
