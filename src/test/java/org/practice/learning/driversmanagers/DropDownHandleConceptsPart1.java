package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class DropDownHandleConceptsPart1 {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com");

        driver.findElement(By.linkText("Create a Page")).click();

        driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 signup_btn _4jy4 _4jy2 selected _51sy\"]")).click();

        // this is the first method n its very easy to do it
        //Always remember in select checkbox or dropdown checkbox it's path always starts with select tag,
        // in most of the case we can find select tag but if you don't find select tag then we can use another method.

        //webelements
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        WebElement year = driver.findElement(By.id("year"));

        Select select = new Select(month);
        select.selectByVisibleText("Mar");

        Select select1 = new Select(day);
        select1.selectByVisibleText("10");

        Select select2 = new Select(year);
        select2.selectByVisibleText("1991");
//__________________________________________________________________
        //use same webelements for the second method

        //This is the second method
        //This method is use to select value in any page where we have more than 50 or many dropdown checkboxes aailable,
        //we can use this method to simplify and make less code to write.
        // we can use any of the the method
        // for this i have created one method and using this static method outside the method and give the value.


        selectValueFromDropDown(month,"Mar");
        selectValueFromDropDown(day,"10");
        selectValueFromDropDown(year,"1991");

        //for screenshort

//        File file = month.getScreenshotAs(OutputType.FILE);
//        try {
//            Files.copy(file.toPath(), Paths.get("capture.png"));
//        } catch (FileNotFoundException exception) {
//            exception.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    }

    public static  void selectValueFromDropDown(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);

    }
        @AfterMethod
        public void tearDown() {
         //   driver.quit();
        }
    }






