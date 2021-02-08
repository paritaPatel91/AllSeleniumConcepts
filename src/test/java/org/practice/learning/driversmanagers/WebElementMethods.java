package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebElementMethods {
    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testdata() throws InterruptedException {
        driver.manage().window().maximize();


        driver.get("https://www.facebook.com");
        WebElement fb = driver.findElement(By.id("u_0_b"));

        //getlocation tells where it is located on the page by x and y location
        //getsize will tells us the size of the element.
        //get rect will tells same like size ,it fetch the element position withrespect to top left corner of element
        // and the the elememnt size instead of using 2 diff methods as getlocation and getsize.
        //Rectangal :: every element in css takes peticular rect space which include border and margin too.
        // so if there is any margin for the element , rect will take margin too.
        //box is made of so many things , like with padding , border and margin.
        // for measuring this one use page ruler and check it.

        System.out.println(fb.getLocation().x);
        System.out.println(fb.getLocation().y);
        System.out.println(fb.getSize().width);
        System.out.println(fb.getSize().height);
        System.out.println(fb.getRect().width);
        System.out.println(fb.getRect().height);


        System.out.println(fb.getCssValue("background-color"));//This background i have copy from the dom in the style tab ,
        //if i type it,it will not show the result in the console or u can direct check it without printing too.
        //cz it is in the ("") we can understand that we can type something but this is not the type one,its the copy one.

        //getcssvalue(): This method is very imp ,it ask in the interview
        //go to inspect and there go to styles at the bottom there is they show background colour or somthing.
        //we need to check that colour , which has special id which suppose to match it .
        //if u cant understand by this u can check atin's vidio of NOV 28th.
        // go to this site https://www.hexcolortool.com

    }

    @AfterMethod
    public void tearDown() {
        //      driver.quit();
    }
}