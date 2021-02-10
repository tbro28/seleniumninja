package com.codeinb8a.java.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

    WebDriver driver;

    public WaitTypes(WebDriver driver) {
        this.driver = driver;
    }


    /**
     *
     * Wait for element and return the element.
     *
     * @param locator
     * @param timeout
     * @return
     */
    public WebElement waitForElement(By locator, int timeout) {

        WebElement element = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (Exception e) {
            System.out.println("Not found.");
        }

        return element;
    }


    /**
     *
     * Click an element after it becomes clickable.
     *
     * @param locator
     * @param timeout
     */
    public void clickWhenReady(By locator, int timeout) {

        WebElement element = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            element = wait.until(
                    ExpectedConditions.elementToBeClickable(locator));

            element.click();

        } catch (Exception e) {
            System.out.println("Not found.");
        }
    }
}
