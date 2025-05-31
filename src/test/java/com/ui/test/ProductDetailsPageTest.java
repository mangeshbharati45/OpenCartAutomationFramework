package com.ui.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ui.base.BaseTest;
import com.ui.utils.CSVUtil;
import com.ui.utils.ExcelUtil;

public class ProductDetailsPageTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
		loginPage = homePage.goToLogin();
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] {
			{"macBook", "MacBook Pro", "MacBook Pro"},
			{"macbook", "MacBook Air", "MacBook Air"},
			{"imac", "iMac", "iMac"},
			{"samsung", "Samsung SyncMaster 941BW", "Samsung SyncMaster 941BW"},
			{"samsung", "Samsung Galaxy Tab 10.1", "Samsung Galaxy Tab 10.1"}
		};
	}
	
	@DataProvider
	public Object[][] getProductTestDataFromExcel() {
		return ExcelUtil.getTestData("productData");
	}
	
	@DataProvider
	public Object[][] getProductTestDataFromCSV() {
		return CSVUtil.csvData("product");
	}

	@Test(dataProvider="getProductTestDataFromCSV", description = "Checking Product Headers")
	public void productHeaderTest(String searchKey, String productName, String expectedProductHeader) {
		searchPage = accPage.doSearch(searchKey);
		productDetailsPage = searchPage.selectProduct(productName);
		String actProductHeader = productDetailsPage.getProductHeader();
		Assert.assertEquals(actProductHeader, expectedProductHeader);
	}
	
	@DataProvider
	public Object[][] getProductImageTestData() {
		return new Object[][] {
			{"macBook", "MacBook Pro", 4},
			{"macbook", "MacBook Air", 4},
			{"imac", "iMac", 3},
			{"samsung", "Samsung SyncMaster 941BW", 1},
			{"samsung", "Samsung Galaxy Tab 10.1", 7}
		};
	}

	@Test(dataProvider = "getProductImageTestData" , description = "Checking Product Image Count")
	public void ProductImagesCountTest(String searchKey, String productName, int expectedImageCount) {
		searchPage = accPage.doSearch(searchKey);
		productDetailsPage = searchPage.selectProduct(productName);
		int actImages = productDetailsPage.getProductImagesCount();
		Assert.assertEquals(actImages, expectedImageCount);
	}

	@Test( description = "Checking Product Information")
	public void productInfoTest() {
		searchPage = accPage.doSearch("macBook");
		productDetailsPage = searchPage.selectProduct("MacBook Pro");
		Map<String, String> actualProductDetailsMap = productDetailsPage.getProductDetailsMap();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualProductDetailsMap.get("Brand"), "Apple");
		softAssert.assertEquals(actualProductDetailsMap.get("Product Code"), "Product 18");
		softAssert.assertEquals(actualProductDetailsMap.get("Reward Points"), "800");
		softAssert.assertEquals(actualProductDetailsMap.get("Availability"), "Out Of Stock");
		softAssert.assertEquals(actualProductDetailsMap.get("productPrice"), "$2,000.00");
		softAssert.assertEquals(actualProductDetailsMap.get("exTextPrice"), "$2,000.00");

		softAssert.assertAll();
	}
}
