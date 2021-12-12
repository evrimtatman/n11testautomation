package com.test.n11.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class N11PerfumeDeodorantPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccountMenu.hOpenMenu > div > a.logoutBtn")
    private WebElement logoutButton;

    @FindBy(css = "#contentListing > div > div > div.filterArea > section.filter.filterSearch > div > input[type=text]")
    private WebElement searchProductInput;

    @FindBy(css = "#allFilterSearchBtn")
    private WebElement searchProductButton;

    public N11PerfumeDeodorantPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public void insertSearchKeywordToInputText(String keyword) {
        searchProductInput.sendKeys(keyword);
    }

    public void clickSearchProductButton() {
        searchProductButton.click();
    }

    public void waitUntilTheLogoutButtonAppears() {
        wait.until((ExpectedCondition<Boolean>) driver -> logoutButton.isEnabled());
    }
}
