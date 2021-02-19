package org.practice.learning.driversmanagers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/");

        driver.findElement(By.linkText("Forgot username?")).click();//linktext


        /*
git remote** html DOM means ::Document object model,it's nothing but html document.

** Each n every page has own html DOM,whatever html source have written over there.

** Browser will read or perfom the action on basis of html DOM,
and selenium will try to see the perticular object or element inside that perticular html DOM.

**For example:
//input[@id='login-username']
Here input = is a html tag/locator/element/object/component
id = is a attribute/properties
and login-username = is a value of attribute

** In the every page there is diff webelement/webobjects
n every webelement has own html tag

* In selenium there are 8 different types of locators abailbel in the BY class (100% IQ)
** There are 8 types of locators,giving priority as per the number
1.Id 2. name 3. x-path 4.css selectors 5. linktext 6. partiallink text 7.classname 8. tagname

** IQ : what is the return type of findelement
ANS: webelement :: which is interface
if it is findelements then it wil be List array
*
* If id is available use id, if id is available in the number format or
*  it's dynamic nature getting change all the time when we reload the page,we have to use x-path in that case.
*
* don't use x path if id is availble in the tag cz it will slow the process
*
* name is also another fast locator but sometimes there are two same name so in that case use x path
*
* dont use unnecesaarily x path if other locators availble.
*
* Id is unique and fatest locator
*
* css selctors not working in some of the complex path , so use xpath instead of that.
*
* link is presentable by : a tag(angular tag)
*
* In partiallink text it is very dangerous , sometimes dosent work,
* partial means using only partial text, sometime there is big two three lines in that case use partiallink text,
* not using thta much
*
* MOST IMP :
* don't use classname in the findelements cz there are chances not to work it
* and there are possibility of same class in the DOM.
*
*
         */

    }
}
