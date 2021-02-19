package com.letskodeit.teachable.ch16.advancedinteractionsscreenshots;

import com.codeinb8a.java.browsers.BrowserSetup;
import com.codeinb8a.java.utilities.GenericMethods;
import com.codeinb8a.java.utilities.GlobalVariables;
import com.codeinb8a.java.utilities.WaitTypes;
import groovyjarjarantlr4.v4.codegen.model.OutputFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.codeinb8a.java.utilities.GlobalVariables.KODE_URL;


public class Screenshot {

    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean headless = false;
    private String browserDriver = "Chrome";
    private GenericMethods gm;
    private WaitTypes wt;

    private LocalDate localDate = LocalDate.now();


    private static String KEY;

    /**
     * Static initializer instead of using a method.
     */
    static {
        try (InputStream input = new FileInputStream(
                "src/test/resources/user.dir")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            KEY = prop.getProperty("src.dir");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @BeforeClass
    public void setUp() {
        System.out.println("Before class.");

        driver = BrowserSetup.setBrowserDetails(browserDriver, headless);
        gm = new GenericMethods(driver);
        wt = new WaitTypes(driver);
        driver.get(KODE_URL);
        driver.manage().timeouts().implicitlyWait(GlobalVariables.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws IOException {


        System.out.println("After class.");

        String filename = "screenshot_" + getRandomString() + ".png";
        String directory = "//screenshots//";

System.out.println(filename);

        //Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\Tim\\java\\selenium\\seleniumninja\\screenshots\\"+filename));
            //FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        /**
         * Another screenshot option.
         * */
        /*
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Path newDir = Paths.get("/Users/Tim/java/selenium/seleniumninja/screenshots/");
        Path source = Paths.get(sourceFile.getPath());

        //create the target directories, if directory exits, no effect
        Files.createDirectories(newDir);

        Files.move(source, newDir.resolve(source.getFileName()),
                StandardCopyOption.REPLACE_EXISTING);
         */

        driver.quit();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test.");
    }


    private String getRandomString() {

        LocalDateTime localDT = LocalDateTime.now();
//        System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyyy_kk:mm:ss").format(localDT));

        return DateTimeFormatter.ofPattern("dd-MM-yyyy_kk_mm_ss").format(localDT);
    }


    /**
     * Test page.
     */
    @Test
    public void testAutocomplete() throws InterruptedException {

        //GlobalActions.waitForSeconds(3);
        Assert.assertEquals(0,0);

    }



}