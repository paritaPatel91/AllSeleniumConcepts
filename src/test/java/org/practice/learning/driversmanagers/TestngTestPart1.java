package org.practice.learning.driversmanagers;

import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestngTestPart1 {

    /*
    In testng we always use test in the end of the class name
    if we dont give priority ,it can pick up random testcases
    Test cases are independant of each other

     */

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
    }

        @Test(groups = "Title")
        public void googeTestTest(){
            String title=driver.getTitle();
            System.out.println("priority 2");

        }

        @Test(priority = 1)
        public void logoTest(){
      boolean element= driver.findElement(By.id("hplogo")).isDisplayed();
            System.out.println("priority 1");
        }

        @Test(groups = "Title")
        public void mailTest(){
            boolean displayed = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
            System.out.println("priority 3");
        }

        @Test(priority = 2)//priortise according to requirement
        public void test(){
            System.out.println("priority 2");
        }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
