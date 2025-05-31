package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ui.base.BaseTest;
import com.ui.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	
	@BeforeClass
	public void registrationPageSetUp() {
		registerPage = homePage.goToRegister();
	}
	
	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"vishal", "mehta", "9876543211", "vishal@123", "yes"},
			{"jyothi", "sharma", "9876543212", "jyothi@123", "no"},
			{"Archana", "verma", "9876543209", "arch@123", "yes"}
		};
	}
	
	@DataProvider
	public Object[][] getUserRegTestDataFromExcel() {
		Object regData[][] = ExcelUtil.getTestData("register");
		return regData;	
	}
	
	@Test(dataProvider="getUserRegTestDataFromExcel", description = "Checking Application Registration Functionality")
	public void userRegistrationTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(
				registerPage.userRegisteration(firstName, lastName, telephone, password, subscribe));
	}
}
