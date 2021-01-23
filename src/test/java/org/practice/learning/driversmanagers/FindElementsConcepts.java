package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsConcepts {

    //Get the totalcount of links on the page
    //Get the text of eah link on the page

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdata11() throws InterruptedException {
        driver.get("https://meet.voicemailtel.com");

     List<WebElement> linkList = driver.findElements(By.tagName("a"));//we can use any tagname here to find total number


//size of linkList::
        System.out.println(linkList.size());

        for (int i = 0; i <linkList.size() ; i++) { // to print link number
            String link = linkList.get(i).getText();
            System.out.println(link);
        }
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);

        driver.quit();
    }

}
