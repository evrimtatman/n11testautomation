package com.test.n11.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class N11LoginPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "#loginContainer > div > div.leftBlock > div > div.facebook_large.medium.facebookBtn.btnLogin")
    private WebElement loginViaFacebookButton;


    public N11LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public void clickLoginViaFacebookButton() {
        loginViaFacebookButton.click();
    }

    public void waitUntilTheLoginViaFacebookButtonAppears() {
        wait.until(ExpectedConditions.visibilityOf(loginViaFacebookButton));
    }


}
