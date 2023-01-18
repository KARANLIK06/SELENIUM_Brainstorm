package com.cydeo.shortVideo;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class T16_LocatingDropdownList {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

        //identify the select element
        WebElement dropDownElement = driver.findElement(By.id("dropdown"));

        // wrap this element inside Select Object
        Select selectobj=new Select(dropDownElement);

        // use ready methods to select option
        selectobj.selectByIndex(2);
        selectobj.selectByValue("2");
        selectobj.selectByVisibleText("Option 2");

        // verify determined option is selected

        String expectedOption = "Option 2";
        String actualOption= selectobj.getFirstSelectedOption().getText();
        if(actualOption.equals(expectedOption)){
            System.out.println("Option 2 selection Passed ");
        }else{
            System.out.println("Option 2 selection Failed ");
        }

        // quit the browser
    }
}
