package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utulities.BrowserUtils;
import com.cydeo.utulities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_Crm_Login extends TestBase {

    @Test
    public void crm_login_test1(){
        // 2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

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

        // 6. Verify title is as expected:
        // Expected: My tasks

        BrowserUtils.verifyTitle(driver,"My tasks");

        /*
        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
         */


        //      USERNAME                    PASSWORD
        // helpdesk1@cybertekschool.com     UserUser
        // Helpdesk2@cybertekschool.com     UserUser
    }

    @Test
    public void crm_login_test2(){
        // 2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        // Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        // 6. Verify title is as expected:
        // Expected: My tasks

        BrowserUtils.verifyTitle(driver,"My tasks");


    }

    @Test
    public void crm_login_test3(){
        // 2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        // Calling my utility method to login helpdesk1
        CRM_Utilities.crm_login(driver,"helpdesk2@cybertekschool.com","UserUser");

        // 6. Verify title is as expected:
        // Expected: Portal

        BrowserUtils.verifyTitle(driver,"Portal");


    }

}
