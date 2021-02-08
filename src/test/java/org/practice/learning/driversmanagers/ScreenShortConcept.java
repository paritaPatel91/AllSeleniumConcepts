package org.practice.learning.driversmanagers;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ScreenShortConcept {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Take screenshort and store as a file format
        //now copy the screenshot to desired location using copyfile //method

        //use Files form java.nio not from others.very imp *********

        driver.get("https://www.walmart.ca/en");

        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Departments')]"));

        //This code is for taking screenshort of only one element.if we wants to take screenshort of whole screen,
        // we can put driver over here and change the name of the file.

        File screenshotAs = element.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotAs.toPath(),Paths.get("walmart11.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        //This code is for thaking screenhort of whole application
        //whenever u run the code we need to change the file.png name everytime,
        // otherwise it will not give the screenshort.

        File walmart = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(walmart.toPath(),Paths.get("walmartaplication11.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

