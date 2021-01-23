package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.nio.ch.SelChImpl;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownHandleConceptsPart3 {
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


        //webelements
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        WebElement year = driver.findElement(By.id("year"));

        Select select = new Select(month);

        select.selectByIndex(10);

        System.out.println(select.isMultiple());//return boolean value

        List<WebElement> options = select.getOptions();
        System.out.println(options.size());//Give me list of all the options availble
//For the getOption they can ask two questions
// (1) what is the used method to check size of the dropdown
        //check total number of days are availble
        int totalDays  = options.size()-1;
        System.out.println("Total days are" + totalDays);


        //(2) Print all values which avaible in the dropdown
        //Get option return list of webelements
        //Whenever there is List , we have to use loop to print cz loop is valiable in the form of indexing and List also.

        for (int i = 0; i <options.size() ; i++) {
            String text = options.get(i).getText();
            System.out.println(text);
            if (text.equals("5")){
                options.get(i).click();
                break;
                // if is use to go upto 5 value only and then break the loop.
            }
        }
//IQ
        //select by text and value will take excat value of the text and value
        //But select by index will go according to index value
// Most imp note is we shold not use selectbyindex cz it can be change in the future ,
// if we added new value to it so always use selectbyext value,it will select the exact value which we need to select it.
        //so do not use it.
// for random giving index number we can use it

    }
    @AfterMethod
    public void tearDown() {
     //      driver.quit();
    }
}
