package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utils.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private by locator
	private final By myAccount = By.xpath("//span[text()='My Account']");
	private final By login = By.linkText("Login");
	private final By register = By.linkText("Register");
	// 2. public page constructor

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. public page actions/methods
		public LoginPage goToLogin () {
			eleUtil.doClick(myAccount);
			eleUtil.doClick(login);
			return new LoginPage(driver);
		}
		
		public RegisterPage goToRegister () {
			eleUtil.doClick(myAccount);
			eleUtil.doClick(register);
			return new RegisterPage(driver);
		}
}
