package com.she.pages;

import com.she.utilities.ConfigurationReader;
import com.she.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "#login")
    public WebElement loginBtn;


    public void login() {

        username.sendKeys(ConfigurationReader.get("Username"));
        password.sendKeys(ConfigurationReader.get("Password"));
        loginBtn.click();
    }





}





