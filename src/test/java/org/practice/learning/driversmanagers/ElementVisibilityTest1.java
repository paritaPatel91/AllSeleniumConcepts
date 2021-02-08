package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementVisibilityTest1 {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://register.freecrm.com/register");


        // isDisplayed method : which shows if there is any button or link available or not (displayed)

        boolean displayed = driver.findElement(By.xpath("//button[@name='action']")).isDisplayed();

        System.out.println(displayed);


        //IsSelected method :only appilcable for checkbox,dropdown,radiobutton
        boolean selected = driver.findElement(By.xpath("//input[@id='terms']")).isSelected();
        System.out.println(selected);

        //Deselected method

        driver.findElement(By.xpath("//input[@id='terms']")).click();
        boolean selected1 = driver.findElement(By.xpath("//input[@id='terms']")).isSelected();
        System.out.println(selected1);

        //isEnabled method : which is used to check,any button or other element which enable or not.
        boolean enabled = driver.findElement(By.xpath("//button[@name='action']")).isEnabled();

        System.out.println(enabled);
    }
    //Iinterview: isdisplayed v/s isenable ;
    //isenable is abailable on the page with enable or not ,return true if enable ,false if inenable.
    //isdisplayed or not.
    //isdisplayed : is the method used to verify presence of a web element within the webpage.
    // The method returns a true value if the specified web element is present on the web page
    // and a false value if the web element is not present on the web page.
    //
    // is displayed is capable to check for the presence of all kinds of web elements availble.

    // is enable method is the methood used to verify if the web element is enabled or disabled within the webpage.
    //is primarily used with buttons.

    //is selected method is the method used to verify if the web element is selected or not .
    // is pre-dominantly used with radio buttons, dropdowns and checkboxes.






}
