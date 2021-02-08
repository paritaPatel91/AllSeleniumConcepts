package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class SelectCalenderByJSPart1 {
    //This is method without testng, in the other example we have use testng.
    //JS means javaScript


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.spicejet.com");

        WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        String dateVal = "22/06";
        selectDateByJs(driver,date,dateVal);
        Thread.sleep(2000);

    }
    public static void selectDateByJs(WebDriver driver,WebElement element,String dateVal){
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].setAttribute('value','"+dateVal+"')",element);


    }
}