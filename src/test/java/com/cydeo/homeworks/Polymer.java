package com.cydeo.homeworks;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Polymer {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void polymer_test() throws InterruptedException {
        driver.get("http://todomvc.com/");

        WebElement javaScriptTab= driver.findElement(By.xpath("//div[text()='JavaScript']"));
        javaScriptTab.click();

        WebElement polymerLink= driver.findElement(By.xpath("//a[@href='examples/polymer/index.html']"));
        polymerLink.click();

        WebElement todosBoxFirstItem= driver.findElement(By.cssSelector("input#new-todo"));
        todosBoxFirstItem.sendKeys("First todo item" + Keys.ENTER);

        WebElement todosBoxSecondItem= driver.findElement(By.cssSelector("input#new-todo"));
        todosBoxSecondItem.sendKeys("Second todo item" + Keys.ENTER);

        WebElement secondItemEdit= driver.findElement(By.xpath("(//label[@class='style-scope td-item'])[2]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(secondItemEdit)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).pause(3000)
                .sendKeys("Edited the content of the second todo item"+Keys.ENTER).perform();


    }
}
