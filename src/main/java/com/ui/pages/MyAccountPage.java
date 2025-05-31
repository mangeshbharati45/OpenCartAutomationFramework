package com.ui.pages;

import static com.ui.constants.AppConstants.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.utils.ElementUtil;
import com.ui.utils.LogUtil;

public class MyAccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private final By headers = By.xpath("//div[@id= 'content']/h2");
	private final By searchField = By.xpath("//input[@name='search']");
	private final By searchIcon = By.cssSelector("div#search button");
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}


	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIs(HOME_PAGE_TITLE, SHORT_DEFAULT_TIMEOUT);
		LogUtil.info("The Accounts page title is "+ title);
		return title;
	}
	
	public List<String> getAccountPageHeaders() {
		List<WebElement> headerList = eleUtil.getElements(headers);
		List<String> headerValList = new ArrayList<String>();
		for(WebElement e : headerList) {
			String text = e.getText();
			System.out.println(text);
			headerValList.add(text);
		}
		return headerValList;
	}
	
	public SearchPage doSearch(String searchKey) {
		eleUtil.doSendKeys(searchField, searchKey);
		eleUtil.doClick(searchIcon);
		return new SearchPage(driver);
	}
}
