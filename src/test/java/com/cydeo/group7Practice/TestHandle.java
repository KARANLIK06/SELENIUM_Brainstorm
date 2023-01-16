package com.cydeo.group7Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestHandle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        ((JavascriptExecutor) driver).executeScript("window.open('http://practice.cydeo.com/','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");




        Set<String> allpages= driver.getWindowHandles();

        for (String eachpage : allpages) {
            driver.switchTo().window(eachpage);
            System.out.println(driver.getTitle());

            if (driver.getTitle().equals("Practice")){
                break;
            }
        }

        driver.findElement(By.xpath("//a[@href='https://cydeo.com/']")).click();


        driver.switchTo().parentFrame();
        System.out.println(driver.getCurrentUrl());


/*

        driver.switchTo().defaultContent();
        System.out.println(driver.getCurrentUrl());


 */


    }




}
