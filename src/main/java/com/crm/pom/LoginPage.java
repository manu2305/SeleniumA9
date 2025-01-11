package com.crm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
@FindBy(name = "user_name")
private WebElement email;
@FindBy(name = "user_password")
private WebElement pwd;
@FindBy(id="submitButton")
private WebElement submit_button;

public void userName(String data) {
	email.sendKeys(data);
}
public void password(String data) {
	pwd.sendKeys(data);
}
public void submit() {
	submit_button.click();
}
}
