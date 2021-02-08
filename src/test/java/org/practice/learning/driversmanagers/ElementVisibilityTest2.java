package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class ElementVisibilityTest2 {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testdata() throws InterruptedException {

        driver.get("https://www1.oanda.com/currency/converter");

        //This is apply to checkboxes and radiobuttons(isSelected)

        WebElement range60 = driver.findElement(By.id("range60"));

        //validate it
        if (range60.isSelected()) {
            System.out.println("selected");
        } else {
            System.out.println("Not selected");
        }
        Thread.sleep(4000);

        //This method is used to scroll into view of the webpage.

       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",range60);
        range60.click();

        Thread.sleep(4000);

        if (range60.isSelected()) {
            System.out.println("selected after click");
        } else {
            System.out.println("Not selected after click");
        }
    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
