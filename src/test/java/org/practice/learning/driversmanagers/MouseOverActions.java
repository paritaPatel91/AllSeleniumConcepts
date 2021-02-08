package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class MouseOverActions {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {

        //Atin's method:

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.cn.ca/en");
        WebElement element = driver.findElement(By.xpath("//a[@id='ctl06__fa0e700633b0f6_repMainNav_topLevelLink_1']"));
        WebElement webelement = driver.findElement(By.id("ctl06__fa0e700633b0f6_repMainNav_repSecondLevel_1_secondLevelLink_3"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).pause(3000).moveToElement(webelement).pause(3000).click().build().perform();

        driver.get("https://www.spicejet.com");
       // Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.id("highlight-addons"));
        WebElement international_connection_baggage = driver.findElement(By.xpath("//a[contains(text(),'International Connection Baggage')]"));
        // Thread.sleep(3000);
        WebElement element11 = driver.findElement(By.xpath("//a[contains(text(),'Covid-19 RT-PCR Test')]"));

        Actions actions1 = new Actions(driver);
        actions.moveToElement(element1).pause(3000).moveToElement(international_connection_baggage).pause(3000).moveToElement(element11).pause(3000).click().build().perform();

        //youtube method:with same URL

        Actions actions11 = new Actions(driver);
        actions.moveToElement( driver.findElement(By.id("ctl06__7cac75b1df08dc_repMainNav_topLevelLink_0"))).build().perform();
        Thread.sleep(3000);
        actions.moveToElement( driver.findElement(By.id("ctl06__7cac75b1df08dc_repMainNav_repSecondLevel_0_secondLevelLink_4"))).click().build().perform();
        Thread.sleep(3000);
        WebElement parita = driver.findElement(By.id("ctl06__7cac75b1df08dc_repMainNav_topLevelLink_3"));
        actions.moveToElement(parita).click().build().perform();

        //There are so many methods for actions use it according to requirements.
        //contextLink which is use when there is element when we right click on that element ,
        // it shows something diff options n when we click somewhere else it shows something diff options.
        



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
