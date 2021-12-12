package com.test.n11.webpage;

import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class N11FavoritePage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "#view")
    private WebElement productListView;


    public N11FavoritePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public String getAddedProductFullName() {
        List<WebElement> productListElements = productListView.findElements(By.tagName("li"));
        WebElement productElement = null;
        if (CollectionUtils.isNotEmpty(productListElements)) {
            productElement = productListElements.get(0);
            return productElement.findElements(By.tagName("a")).get(0).findElements(By.tagName("h3")).get(0).getText();
        }
        return null;
    }

}
