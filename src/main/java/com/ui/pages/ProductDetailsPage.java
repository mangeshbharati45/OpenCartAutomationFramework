package com.ui.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.constants.AppConstants;
import com.ui.utils.ElementUtil;
import com.ui.utils.LogUtil;

public class ProductDetailsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String, String> productMap;

	private final By productHeader = By.tagName("h1");
	private final By productImages = By.cssSelector("ul.thumbnails img");
	private final By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private final By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductHeader() {
		String header = eleUtil.waitForElementVisible(productHeader, AppConstants.SHORT_DEFAULT_TIMEOUT).getText();
		LogUtil.info("product header: " + header);
		return header;
	}

	public int getProductImagesCount() {
		int imageCount = eleUtil.waitForAllElementsVisible(productImages, AppConstants.MEDIUM_DEFAULT_TIMEOUT).size();
		System.out.println("Total number of images: " + imageCount);
		return imageCount;
	}
	
	public Map<String, String> getProductDetailsMap() {
		//productMap = new HashMap<String, String>();
		productMap = new LinkedHashMap<String, String>();
		
		productMap.put("productheader", getProductHeader());
		productMap.put("productimages", String.valueOf(getProductImagesCount()));
		getProductMetaData();
		getProductPriceData();
		System.out.println("Full product details: "+productMap);
		return productMap;
	}

//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: Out Of Stock

	private void getProductMetaData() {
		List<WebElement> metaList = eleUtil.getElements(productMetaData);
		for (WebElement e : metaList) {
			String metaData = e.getText();
			String meta[] = metaData.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productMap.put(metaKey, metaValue);
		}
	}

//	$2,000.00
//	Ex Tax: $2,000.00

	private void getProductPriceData() {
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String productPrice = priceList.get(0).getText();
		String exTextPrice = priceList.get(1).getText().split(":")[1].trim();
		productMap.put("productPrice", productPrice);
		productMap.put("exTextPrice", exTextPrice);
	}
}
