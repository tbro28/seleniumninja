package com.letskodeit.teachable.ch16.advancedinteractions;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
import com.codeinb8a.java.utilities.GlobalActions;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.codeinb8a.java.utilities.WaitTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;

public class Calendar {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";
    private GenericMethods gm;
    private WaitTypes wt;

    private LocalDate localDate = LocalDate.now();

    @BeforeEach
    public void setUp() {

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);

        gm = new GenericMethods(driver);


        wt = new WaitTypes(driver);

        //Action
        driver.get(KODE_URL);

        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        //driver.close();
    }

    /**
     * Test page.
     */
    @Test
    public void SelectDatesKayak() throws InterruptedException {

        //  //div[@aria-label='February 25, 2021']
        //expedia
        //southwest
        //alaska
        //kayak
        //redfin
        //zillow


        driver.get("https://www.kayak.com");

        //div[@class='PDPe-from']


        driver.findElement(By.cssSelector(".PDPe-from-icon > span:nth-child(1) > svg:nth-child(1)")).click();
        driver.findElement(By.xpath("div[@class='PDPe-from']")).click();
        driver.findElement(By.xpath("//div[@aria-label='February 25, 2021']")).click();

        GlobalActions.waitForSeconds(3);

    }


    /**
     * Test page.
     */
    @Test
    public void SelectDatesExpedia() throws InterruptedException {

        //  //div[@aria-label='February 25, 2021']
        //expedia
        //southwest
        //alaska
        //kayak
        //redfin
        //zillow
        String dayOfToday = "//button[@data-day='"+localDate.getDayOfMonth()+"']";


        System.out.println(dayOfToday);

        driver.get("https://www.expedia.com");

        //div[@class='PDPe-from']
        driver.findElement(By.xpath("//button[@id='d1-btn']")).click();
        driver.findElement(By.xpath(dayOfToday));


        System.out.println(driver.findElement(By.xpath("//button[@id='d1-btn']")).getText());
        wt.clickWhenReady(By.xpath("//button[@id='d1-btn']"), 3);
        //driver.findElement(By.xpath("//button[@id='d1-btn']")).click();

        System.out.println(driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).getText());
        driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();

        System.out.println(driver.findElement(By.id("d2-btn")).getText());
        driver.findElement(By.id("d2-btn")).click();

        System.out.println(driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).getText());
        driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();

        GlobalActions.waitForSeconds(3);

    }

}