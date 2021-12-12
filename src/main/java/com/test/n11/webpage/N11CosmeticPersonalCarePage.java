package com.test.n11.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class N11CosmeticPersonalCarePage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccountMenu.hOpenMenu > div > a.logoutBtn")
    private WebElement logoutButton;

    @FindBy(css = "#contentCategory > div:nth-child(1) > div.topCont > div.subCatMenu.l12 > ul > li:nth-child(1) > a")
    private WebElement perfumeDeodorantLink;

    public N11CosmeticPersonalCarePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }


    public void waitUntilTheLogoutButtonAppears() {
        wait.until((ExpectedCondition<Boolean>) driver -> logoutButton.isEnabled());
    }

    public void clickPerfumeDeodorantLink() {
        perfumeDeodorantLink.click();
    }

}
