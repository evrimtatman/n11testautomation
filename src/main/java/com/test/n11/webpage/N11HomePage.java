package com.test.n11.webpage;

import common.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class N11HomePage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    private static String N11_PAGE_URL = "https://www.n11.com/";

    @FindBy(css = "#footer")
    private WebElement footerElement;


    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.withLocalization > div > div > a.btnSignIn")
    private WebElement loginButton;

    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccountMenu.hOpenMenu > div > a.logoutBtn")
    private WebElement logoutButton;

    @FindBy(css = "#contentMain > div > nav > ul > li:nth-child(5) > a")
    private WebElement cosmeticPersonalCareLink;

    @FindBy(css = "#footer > div > div.fWrapper > div:nth-child(2) > div > ul > li:nth-child(4) > a")
    private WebElement brandsPageLink;

    public N11HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public void goToHomePage() {
        webDriver.get(N11_PAGE_URL);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void waitUntilTheLoginButtonAppears() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    public void waitUntilTheLogoutButtonAppears() {
        wait.until((ExpectedCondition<Boolean>) driver -> logoutButton.isEnabled());
    }

    public boolean verifyUserHasLoggedIn() {
        return logoutButton.isEnabled();
    }

    public void goToCosmeticPersonalCare() {
        cosmeticPersonalCareLink.click();
    }

    public List<String> findAllLinksOnFooter() {
        List<WebElement> allLinkElementsOnFooter = footerElement.findElements(By.tagName("a"));
        return allLinkElementsOnFooter.stream().map(webElement -> webElement.getAttribute("href")).collect(Collectors.toList());

    }

    public void goToBrandsPage() {
        brandsPageLink.click();
    }

    public void writeAllLinksOnFooterToTxtFile(List<String> linkList)  {
        TestUtil.writeFile(linkList);
    }
}
