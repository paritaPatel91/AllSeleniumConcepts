package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HTMLUNitDriverConcept {

    // session 10

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
      //  driver=new ChromeDriver();
        //htmlunitdriver is not available in selenium 3.x version
        //This is the new thing happening in selenium 3 .I.q
        //htmlunitdriver to use this concept , we have to dowload htmlunitdriver JAR file

        //Advantage:
        //1. Testing is happening behind the scene - no browser is launched
        //2. very fast - execution of test cases -- very fast -- perfomance of the script.
        //3. not suitable for action class -- user actions -- mousemovement, doubleclick, drag and drop
        // 4. it can called as Ghost driver --- Headless browser.
        //HtmlUNitDriver -- java
        //PhantomJS-- javaScipt


        WebDriver driver = (WebDriver) new HTMLUNitDriverConcept();



    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();//maximize window(2)
        driver.manage().deleteAllCookies();//delete all cookies(3)

        driver.get("https://freecrm.com");
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("Parita");

        driver.findElement(By.name("password")).sendKeys("Parita");
        System.out.println(driver.getTitle());




    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    }
