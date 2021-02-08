package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestngAssertionConcept {

    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.ca");
    }

    @Test()
    public void amzonTestTest() {
        String title = driver.getTitle();
        System.out.println(title);

        Assert.assertEquals(title, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items", "Title is not matched");

        /*
        first we put here what we likes validate- ttile
        second we put here actual value suppose to be print
        and third we put here if value is wrong is what msg suppose to print here.
        assertion very very imp in the testng to validate the testcases ,
         without it validation testcases are not complete
         we use testng.xml file for this
         */
    }
        @Test
        public void logoTest(){
            boolean element= driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
            Assert.assertTrue(element);
            Assert.assertEquals(element,true);//another way to validate,both same method
        }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}