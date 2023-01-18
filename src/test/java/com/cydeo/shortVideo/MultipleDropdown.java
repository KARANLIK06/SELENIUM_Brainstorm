package com.cydeo.shortVideo;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MultipleDropdown {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

        // identify the dropdown with multiple select options
        WebElement multiItemDrop= driver.findElement(By.name("Languages"));

        // wrap this element into Select object
        Select multiItemSelect= new Select(multiItemDrop);

        // check if this element has multi select option
        System.out.println("multiItemSelect.isMultiple() = " + multiItemSelect.isMultiple());

        // select item
        multiItemSelect.selectByIndex(2);
        multiItemSelect.selectByValue("ruby");
        multiItemSelect.selectByVisibleText("Python");

        // deselect item
        //multiItemSelect.deselectByIndex(2);
        //multiItemSelect.deselectByValue("ruby");
        //multiItemSelect.deselectByVisibleText("Python");

        multiItemSelect.deselectAll();
    }
}
