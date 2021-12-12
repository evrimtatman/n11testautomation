package com.test.n11.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;


public class FacebookLoginPage {

    private WebDriver webDriver;

    @FindBy(css = "#email")
    private WebElement facebookUsernameInput;

    @FindBy(css = "#pass")
    private WebElement facebookPasswordInput;

    @FindBy(css = "label.uiButton.uiButtonConfirm.uiButtonLarge")
    private WebElement facebookPasswordInputLoginButton;

    private String parentWindow;


    public FacebookLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void switchToFacebookLoginPage() {
        parentWindow = webDriver.getWindowHandle();
        Set<String> handles = webDriver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                webDriver.switchTo().window(windowHandle);
            }
        }
    }

    public void insertFacebookUsername(String username) {
        facebookUsernameInput.sendKeys(username);
    }

    public void insertFacebookPassword(String password) {
        facebookPasswordInput.sendKeys(password);
    }

    public void clickToFacebookLoginButton() {
        facebookPasswordInputLoginButton.click();
        webDriver.switchTo().window(parentWindow);
    }
}
