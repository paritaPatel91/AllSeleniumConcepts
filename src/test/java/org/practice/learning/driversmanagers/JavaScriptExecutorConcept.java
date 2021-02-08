package org.practice.learning.driversmanagers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorConcept {

//only method 1 and 2 not working as per the script but still e can try in other page.
    //Method 1 n 2 is for highlighting the button for 10 times or whatever , but its not working for me
    //method 3 is for making mark on the button or anywhere where we can mark with marker on the button,
    // where we wants to show any bug we find it we can take screenshort of it and send it to the developer.


    //What is JavaScriptexecutor?
    //is a class in which we have to cast driver in to javasrciptexecutor.
    //use to execute javascript code

    //driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://freecrm.com");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();
        driver.findElement(By.name("email")).sendKeys("patelparita67@yahoo.com");

        driver.findElement(By.name("password")).sendKeys("P91");

        WebElement loginbtn = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));


        flash(loginbtn, driver);//highlight the element

        drawBorder(loginbtn, driver);//draw a border

        generateAlert(driver, "There is a problem with login button in the page");//generate alert message

       scrollPageDown(driver);//scroll page down

        WebElement webElement = driver.findElement(By.xpath("//a[@class='btn btn-sm-3 btn-primary btn-icon btn-icon-left btn-shadow btn-rect pull-xs-right offset-top-30 reveal-block reveal-xs-inline']"));
        scrollIntoView(webElement,driver);//srollintoview method
    }
    //method one n two use together to highlight the elements.
    //Method 1
    public static void flash(WebElement element, WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String bgColour = element.getCssValue("backgroundColour");
        for (int i = 0; i < 10; i++) {
            changeColour("rgb(0,200,0)", element, driver);//1
            changeColour(bgColour, element, driver);//2
            // Thread.sleep(5000);

        }
    }

    //Method 2
    public static void changeColour(String color, WebElement element, WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColour='" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {

        }

    }
    //method 3
    //method 3 is for making mark on the button or anywhere where we can mark with marker on the button,
    // where we wants to show any bug we find it we can take screenshort of it and send it to the developer.

    public static void drawBorder(WebElement element, WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);//draw a border


    }
// Method 4 : Generate alert

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");

    }
    //Method 5 : we can click on any button or link by javaScriptExecutor
    //cz javascript executor will directly hit the javascript library directly

    public static void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js =((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();",element);


    }

  //  Method 6
    //To scroll the page to end of the page
    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js =((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    //method 7
    //we can go to perticular element by scrolling automatically and click that perticular element
    public static void scrollIntoView(WebElement element,WebDriver driver){
        JavascriptExecutor js =((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);


    }
}