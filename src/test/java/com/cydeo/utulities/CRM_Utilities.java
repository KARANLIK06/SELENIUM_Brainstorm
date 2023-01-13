package com.cydeo.utulities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    public static void crm_login(WebDriver driver){

        // 3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");
        //username.sendKeys("Helpdesk2@cybertekschool.com");

        // 4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        // 5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

    }

    public static void crm_login(WebDriver driver,String username,String  password){

        // 3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(username);

        //      USERNAME                    PASSWORD
        // helpdesk1@cybertekschool.com     UserUser
        // Helpdesk2@cybertekschool.com     UserUser

        // 4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(password);

        // 5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

    }
}
