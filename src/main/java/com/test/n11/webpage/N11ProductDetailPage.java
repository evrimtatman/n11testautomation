package com.test.n11.webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class N11ProductDetailPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    private static String N11_FAVORITE_PAGE_URL = "https://www.n11.com/hesabim/favorilerim";


    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccountMenu.hOpenMenu > div > a.logoutBtn")
    private WebElement logoutButton;

    @FindBy(css = "#getWishList")
    private WebElement wishListButton;

    @FindBy(css = "body > div.lightBox > div > span.closeBtn")
    private WebElement approveButton;

    @FindBy(css = "#addToFavouriteWishListBtn")
    private WebElement addToFavouriteWishListButton;

    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccountMenu.hOpenMenu > div > a:nth-child(2)")
    private WebElement favouritePageButton;

    @FindBy(css = "#unf-p-id > div > div.unf-p-cvr > div.unf-p-left.proDetailArea > div.unf-p-lBox > div.unf-p-detail > div.unf-p-title > div.proNameHolder > div > h1")
    private WebElement productNameLabel;

    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccount")
    private WebElement myAccountMenu;


    public void goToFavoritePage() {
        webDriver.navigate().to(N11_FAVORITE_PAGE_URL);
    }

    public N11ProductDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public void clickWishListButton() {
        wishListButton.click();
    }


    public void clickAddToFavouriteWishListButton() {
        addToFavouriteWishListButton.click();
    }

    public void clickApproveButton() {
        approveButton.click();
    }

    public String getSelectedProductName() {
        return productNameLabel.getText();
    }

    public void waitUntilTheLoginButtonAppears() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
    }

    public void waitUntilTheAddToFavouriteWishListButtonAppears() {
        wait.until(ExpectedConditions.visibilityOf(addToFavouriteWishListButton));
    }
}
