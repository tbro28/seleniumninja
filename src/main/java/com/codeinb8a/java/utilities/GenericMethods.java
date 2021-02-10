package com.codeinb8a.java.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class GenericMethods {

    WebDriver webDriver;

    public GenericMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getElement(String locator, String type) {

        type = type.toLowerCase();
        WebElement webElement = null;

        if (type.equals("id")) {
            webElement = webDriver.findElement(By.id(locator));
            System.out.println(webElement);
        }
        else if (type.equals("name")) {
            webElement = webDriver.findElement(By.xpath(locator));
            System.out.println(webElement);
        }
        else if (type.equals("xpath")) {
            webElement = webDriver.findElement(By.name(locator));
            System.out.println(webElement);
        }
        else if (type.equals("cssSelector")) {
            webElement = webDriver.findElement(By.cssSelector(locator));
            System.out.println(webElement);
        }
        else if (type.equals("className")) {
            webElement = webDriver.findElement(By.className(locator));
            System.out.println(webElement);
        }
        else if (type.equals("tagName")) {
            webElement = webDriver.findElement(By.tagName(locator));
            System.out.println(webElement);
        }
        else if (type.equals("linkText")) {
            webElement = webDriver.findElement(By.linkText(locator));
            System.out.println(webElement);
        }
        else
            System.out.println("Not found.");

        return  webElement;
    }


    /**
     *
     * @param locator
     * @param type
     * @return
     */
    public List<WebElement> getElementList(String locator, String type) {

        type = type.toLowerCase();
        WebElement webElement;
        List<WebElement> webElements = null;

        if (type.equals("id")) {
            webElements = webDriver.findElements(By.id(locator));
            System.out.println(webElements);
        }
        else if (type.equals("name")) {
            webElements = webDriver.findElements(By.name(locator));
            System.out.println(webElements);
        }
        else if (type.equals("xpath")) {
            webElements = webDriver.findElements(By.xpath(locator));
            System.out.println(webElements);
        }
        else if (type.equals("cssSelector")) {
            webElements = webDriver.findElements(By.cssSelector(locator));
            System.out.println(webElements);
        }
        else if (type.equals("className")) {
            webElements = webDriver.findElements(By.className(locator));
            System.out.println(webElements);
        }
        else if (type.equals("tagName")) {
            webElements = webDriver.findElements(By.tagName(locator));
            System.out.println(webElements);
        }
        else if (type.equals("linkText")) {
            webElements = webDriver.findElements(By.linkText(locator));
            System.out.println(webElements);
        }
        else
            System.out.println("Not found.");

        return webElements;
    }


    /**
     *
     * @param locator
     * @param type
     * @return
     */
    public boolean isElementPresent (String locator, String type) {

        List<WebElement> elementList = getElementList(locator, type);

        if(elementList.size() > 0)
            return true;
        else
            return false;
    }

}
