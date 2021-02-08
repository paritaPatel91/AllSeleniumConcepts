package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EXplicitwaitExample {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void testdata11() throws InterruptedException {

        driver.get("https://zoom.us/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.id("truste-consent-button")).click();


     driver.findElement(By.xpath("//a[@class='btn cta-bgyellow signupfree']")).click();

        WebElement element = driver.findElement(By.xpath("//span[@id='select-0']"));
        element.click();
        driver.findElement(By.id("select-item-select-0-5")).click();

        WebElement element1= driver.findElement(By.id("select-1"));
        element1.click();
        driver.findElement(By.id("select-item-select-1-6")).click();


        WebElement element2= driver.findElement(By.id("select-2"));
        element2.click();
        driver.findElement(By.id("select-item-select-2-2")).click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='zm-button__slot']")));
        until.click();

        //IMP NOTES : never choose disable path,it will never work.
        //This code is working fine.
        // Different Locators: id,css ,xpath, tag, classname, Linktext, partialLinktext xpath


    }

    @AfterMethod
    public void tearDown() {
        //      driver.quit();

    }
}