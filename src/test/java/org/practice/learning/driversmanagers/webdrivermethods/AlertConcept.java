package org.practice.learning.driversmanagers.webdrivermethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

    public class AlertConcept {

        private WebDriver driver;

        @BeforeSuite
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void testName() throws InterruptedException {
        driver.get("https://explore.zoom.us/livedemo");

        // This is very imp to use for dropdown method we can select the value by using select method::

        Select select = new Select(driver.findElement(By.id("00Nd0000007MFAl")));
        select.selectByVisibleText("2-10");
        Thread.sleep(10000);

//*[@id="00Nd0000007MFAl"]

                  driver.get("https://www.guess.com/ca/en/login/?rurl=1");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='js-get-consent cookie__close']")).click();

        driver.manage().window().maximize();

        driver.findElement(By.id("register-tab")).click();

        driver.findElement(By.id("registration-form-fname")).sendKeys("saumyaa");
        driver.findElement(By.id("registration-form-lname")).sendKeys("Patil");
        driver.findElement(By.xpath("//input[@id='registration-form-email']")).sendKeys("smnu19@gmail.com");
        driver.findElement(By.id("registration-form-password")).sendKeys("Mp103920$");
        driver.findElement(By.className("custom-checkbox__label mt-4"));
        driver.findElement(By.xpath("//button[@type='submit' and @class='button large primary my-4']"));

//           Working with the Alert Method
//            how to switch from one element to another when pop-up come up
//            first step will switch its position to alert message

            Alert alert = driver.switchTo().alert();

            // second step will get the text whatever written on the alert message

            System.out.println(alert.getText());

            //this last step will click on the ohk button of the alert
            alert.accept();

            //sometimes there is cancel button over there , to use cancel button use this below method
            alert.dismiss();
            // for this alert we can not use x- path or any other locators so use this method:

            // validating the alert method

       String text = alert.getText();
       if (text.equals("Please enter a valid user name")){
           System.out.println("correct alert message");
       }else {
           System.out.println("Incorrect alert message");
       }

        }

        @AfterSuite
        public void tearDown() throws InterruptedException {

            //This one used to close the URL
            //   driver.quit();

        }
    }
