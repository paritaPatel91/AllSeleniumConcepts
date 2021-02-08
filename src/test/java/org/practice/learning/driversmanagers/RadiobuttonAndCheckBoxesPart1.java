package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RadiobuttonAndCheckBoxesPart1 {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/p/practice");


    }

    @Test
    public void testdata() throws InterruptedException {
        WebElement bmwradiobtn= driver.findElement(By.id("bmwradio"));
        System.out.println(bmwradiobtn.getAttribute("id"));
        bmwradiobtn.click();
        Thread.sleep(2000);

        WebElement benzradiobtn= driver.findElement(By.id("benzradio"));
        benzradiobtn.click();
        Thread.sleep(2000);

        WebElement benzcheckbox= driver.findElement(By.id("bmwcheck"));
      benzcheckbox.click();
        Thread.sleep(2000);

        WebElement hondacheck= driver.findElement(By.id("hondacheck"));

        hondacheck.click();
        Thread.sleep(2000);

        System.out.println("radiobutton"+bmwradiobtn.isSelected());
        System.out.println("checkbox"+hondacheck.isSelected());

    }
    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
