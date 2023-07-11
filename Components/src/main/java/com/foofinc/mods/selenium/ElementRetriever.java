package com.foofinc.mods.selenium;

import org.openqa.selenium.*;

import java.util.List;

public class ElementRetriever {

    private WebDriver driver;

    public ElementRetriever(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findFromDriver(String tag, String attributeName, String attributeString) {
        return findFromContext(driver, tag, attributeName, attributeString);
    }

    public WebElement findFromElement(WebElement element, String tag, String attributeName, String attributeString) {
        return findFromContext(element, tag, attributeName, attributeString);
    }

    public WebElement findByAttribute(String attributeName, String attributeString) {
        return findFromContext(driver, null, attributeName, attributeString);
    }

    private WebElement findFromContext(SearchContext context,
                                       String tag,
                                       String attributeName,
                                       String attributeString) {
        if (tag == null) {
            tag = "*";
        }

        List<WebElement> tagElements = context.findElements(By.tagName(tag));
        for (WebElement e : tagElements) {
            if (e != null) {
                try {
                    String attribute = e.getAttribute(attributeName);
                    if (attribute != null && attribute.equalsIgnoreCase(attributeString)) {
                        return e;
                    }
                } catch (Exception ignore) {
                }
            }
        }
        throw new NotFoundException("Could not find web element");
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
