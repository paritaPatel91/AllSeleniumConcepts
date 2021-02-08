package org.practice.learning.driversmanagers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;


public class Cookies {

    //Whatever we search on the google,it drops the cookies on it and it will pick up by someone else,
    // which is used to tract us on the company.
    // In a company use deleteallcookies, like we do in most of the class.
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().window().maximize();


        driver.get("https://www1.oanda.com/currency/converter");

        WebElement input = driver.findElement(By.id("base_currency_input"));
        input.sendKeys("CAD");
        input.sendKeys(Keys.ENTER);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
/*
         WebDriver.ImeHandler ime();
         This one is use for applications which supports more than one language,
         we are not using this in canada cz frenach can be supported without ime handler.

 */
    }
        @AfterMethod
        public void tearDown() {
            //      driver.quit();
        }
    }





