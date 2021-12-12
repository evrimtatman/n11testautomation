package com.test.n11.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class N11BrandPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = "#footer")
    private WebElement footerElement;

    public N11BrandPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    public List<String> findAllLinksOnFooter() {
        List<WebElement> allLinkElementsOnFooter = footerElement.findElements(By.tagName("a"));
        return allLinkElementsOnFooter.stream().map(webElement -> webElement.getAttribute("href")).collect(Collectors.toList());

    }
}
