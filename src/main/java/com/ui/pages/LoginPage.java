package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.ui.utils.ElementUtil;
import com.ui.utils.LogUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private by locator

	private final By email = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@value='Login']");

	// 2. public page constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// 3. public page actions/methods
	@Step("login with valid username: {0} and password: {1}")
	public MyAccountPage doLogin(String username, String pwd) {
		LogUtil.info("user credentials: " + username + ":" + pwd);
		ChainTestListener.log("user credentials: " + username + ":" + pwd);
		eleUtil.doSendKeys(email, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new MyAccountPage(driver);
	}

}
