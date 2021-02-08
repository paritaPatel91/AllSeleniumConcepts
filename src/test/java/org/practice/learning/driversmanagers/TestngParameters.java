package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class TestngParameters {

    /*
    use testng2 file here
    This one doent work ,use Atin's method

    Data driven : from diff resources(how you drive your data from diff reaources?)ans is below
    1. Excel file : test data
    2. Properties file : Env variables or Test data
    3. testng.xml : Env variable
    4. xml files
    5. JSON file
    6. DB
    */
    WebDriver driver;


    @Test
    @Parameters({"url","email","pass"})
    public void test1() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");//url
        driver.findElement(By.id("email")).sendKeys("pa7@yahoo.com");//usereamilid
        driver.findElement(By.id("pass")).sendKeys("pru");//enter pass

}
    }
