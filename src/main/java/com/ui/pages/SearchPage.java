package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.constants.AppConstants;
import com.ui.utils.ElementUtil;
import com.ui.utils.LogUtil;

public class SearchPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private final By productCount = By.cssSelector("div.product-thumb");
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public int searchResultsCount() {
		int searchCount = 
				eleUtil.waitForAllElementsPresence(productCount, AppConstants.MEDIUM_DEFAULT_TIMEOUT).size();
		System.out.println("total number of search product: "+searchCount);
		return searchCount;
	}
	
	public ProductDetailsPage selectProduct(String productName) {
		LogUtil.info("The product is "+ productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductDetailsPage(driver);
	}
	
}
