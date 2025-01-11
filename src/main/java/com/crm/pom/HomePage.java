package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement profile;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOut;
	@FindBy(xpath ="//td[@class='moduleName']")
	private WebElement home;
	@FindBy(xpath ="//a[text()='Organizations']")
	private WebElement organization;
	public void profile() {
		profile.click();
	}
	public void signOut() {
		signOut.click();
	}
	public WebElement home() {
		return home;
	}
	public void organization() {
		organization.click();
	}
}
