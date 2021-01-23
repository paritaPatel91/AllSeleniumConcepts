package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownHandleConceptsPart4 {
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


        //This is the first Method
        // This is the Generic Method which use to give all the values and print it using loop:
//        List<WebElement> monthList = driver.findElements(By.xpath("//select[@id='month']//option"));
//        System.out.println(monthList.size());
//
//        for (int i = 0; i < monthList.size(); i++) {
//            System.out.println(monthList.get(i).getText());
//            //any value which we wants to select it we can use IF method
//            if (monthList.get(i).getText().equals("Mar")) {
//                monthList.get(i).click();
//                break;
//            }
//        }

        // This is the second Method: without using  select method :
        //Selecting the dropdown value


        String month = "//select[@id='month']//option";
        String day = "//select[@id='day']//option";
        String year = "//select[@id='year']//option";

        dropDownValue(month,"May");

    }
    public void dropDownValue(String xpath , String value){

        List<WebElement> monthList = driver.findElements(By.xpath(xpath));
        System.out.println(monthList.size());

        for (int i = 0; i < monthList.size(); i++) {
            System.out.println(monthList.get(i).getText());
            //any value which we wants to select it we can use IF method
            if (monthList.get(i).getText().equals(value)) {
                monthList.get(i).click();
                break;
            }
        }
    }
    @AfterMethod
    public void tearDown() {
        //      driver.quit();
    }
}