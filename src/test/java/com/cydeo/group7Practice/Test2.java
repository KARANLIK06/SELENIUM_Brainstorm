package com.cydeo.group7Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {


        //TC #1: Smartbear software link verification
        //1. Open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”

        WebElement username = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        username.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test");

        //5. Click to Login button
        WebElement loginbutton= driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginbutton.click();

        /*
        //6. Print out count of all the links on landing page
        //7. Print out each link text on this page
        List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
        }

        WebElement tablelocate= driver.findElement(By.xpath("//table//tbody//tr[6]//td[7]"));
        System.out.println(tablelocate.getText());


         */
/*
        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr[1]//td[3]"));

        for (WebElement eachproduct : products) {
            System.out.println(eachproduct.getText());
        }

 */
        List<WebElement> products = driver.findElements(By.xpath("//table//tbody//tr[1]//td[3]"));
        List<WebElement> names = driver.findElements(By.xpath("//table//tbody//tr[1]//td[2]"));

        for (int i = 1; i <9 ; i++) {
            System.out.println(names.get(i).getText()+"----------"+products.get(i).getText());
        }
    }
}

