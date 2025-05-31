package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ui.base.BaseTest;

public class SearchPageTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
		loginPage = homePage.goToLogin();
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test( description = "Checking Product Search Functionality")
	public void searchCountTest() {
		searchPage = accPage.doSearch("airtel");
		int actSearchCount = searchPage.searchResultsCount();
		Assert.assertEquals(actSearchCount, 0);

	}
}
