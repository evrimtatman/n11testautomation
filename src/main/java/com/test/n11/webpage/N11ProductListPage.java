package com.test.n11.webpage;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class N11ProductListPage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(css = "#view")
    private WebElement productList;

    @FindBy(css = "#header > div > div > div.hMedMenu > div.customMenu > div.myAccountHolder.customMenuItem.hasMenu.withLocalization > div.myAccountMenu.hOpenMenu > div > a.logoutBtn")
    private WebElement logoutButton;

    public N11ProductListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public void waitUntilTheLogoutButtonAppears() {
        wait.until((ExpectedCondition<Boolean>) driver -> logoutButton.isEnabled());
    }
    public void clickSeventhElementInProductList() {
        List<WebElement> productListElements = productList.findElements(By.tagName("li"));
        WebElement webElement = null;
        if (CollectionUtils.isNotEmpty(productListElements)) {
            List<WebElement> collect = productListElements
                    .stream()
                    .filter(productListElement -> StringUtils.isNotEmpty(productListElement.getText()))
                    .collect(Collectors.toList());
            webElement = collect.get(6);
            Optional.ofNullable(webElement).ifPresent(WebElement::click);
        }
    }


}
