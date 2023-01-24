package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractices {
    @Test
    public void task_4_and_5_test(){
        //TC #4: Scroll practice
        // 1- Open a chrome browser
        // 2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        // 3- Scroll down to “Powered by CYDEO”
        Actions actions=new Actions(Driver.getDriver());

        WebElement cydeoLink= Driver.getDriver().findElement(By.linkText("CYDEO"));

        // 4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).perform();

        //TC #5: Scroll practice 2
        // 1- Continue from where the Task 4 is left in the same test.
        // 2- Scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();

        Driver.closeDriver();
    }
}
