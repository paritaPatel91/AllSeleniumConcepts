package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectCalenderByJSPart2 {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://www.spicejet.com");

        //Depart date
        WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        String dateVal = "22/04";
        selectDateByJs(driver, date, dateVal);
        // Thread.sleep(2000);


        //Return Date
        WebElement date1 = driver.findElement(By.id("ctl00_mainContent_view_date2"));
        String dateVal1 = "10/05";
        selectDateByJs11(driver, date1, dateVal1);
        // Thread.sleep(2000);


    }

    public static void selectDateByJs(WebDriver driver, WebElement element, String dateVal) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','" + dateVal + "')", element);


    }

    public static void selectDateByJs11(WebDriver driver, WebElement element, String dateVal1) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','" + dateVal1 + "')", element);
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();//select checkbox of family and friends

}

/*
     JavaScript there is one disadvantage: cz we are injecting directly into dom ,
     it can select wrong values too.like it can take 32 date too which is not possible
      IQ -- two methods of selecting dates in webpage
      1) by using iterator and for loop
      2) and by using java script
      in iterator and for loop , if we use wrong value ,it will give us error messsge which is not posible in JS.
 */
        @AfterSuite
    public void tearDown() {
        //      driver.quit();

    }
}