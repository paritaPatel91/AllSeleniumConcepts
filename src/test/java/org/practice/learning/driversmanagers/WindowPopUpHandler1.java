package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPopUpHandler1 {


    //To switch from one window or tab to another and work on that window we can use this below method,
    // plz write all code to perfrom this action.



    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {

        driver.manage().window().maximize();
    //    driver.manage().deleteAllCookies();

        // to give time to pageload use pageloadtimeout


    //    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.walmart.ca/en");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("accept-privacy-policies")).click();

        WebElement element = driver.findElement(By.linkText("Clothing"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).pause(100).click(element).build().perform();
        Thread.sleep(10000);


        // upto this same code use this down code to get windowhandler


        String currwindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for (String win : windows){
            if (currwindow!=win){
                driver.switchTo().window(win);

            }
        }
        Thread.sleep(10000);
        driver.switchTo().window(currwindow);

        Thread.sleep(5000);
        driver.close();

        System.out.println(currwindow);
        System.out.println(windows);


    }

    @AfterMethod
    public void tearDown() {

       driver.quit();
    }
}