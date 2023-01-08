package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_Alert_Practice2 {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #1: Information alert practice
        // 1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void alert_test2() throws InterruptedException {

        // 3. Click to “Click for JS Confirm” button
        WebElement jsConfirmAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirmAlertButton.click();

        // 4. Click to OK button from the alert
        Alert confirmAlert =driver.switchTo().alert();
        Thread.sleep(3000);
        confirmAlert.accept();


        // 5. Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertEquals(resultText.getText(), "You clicked: Ok");

    }
}
