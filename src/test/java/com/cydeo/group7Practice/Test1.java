package com.cydeo.group7Practice;

import com.cydeo.utulities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void amazon_test(){
        driver.get("https://www.amazon.com/");
        String expectedTitle ="Amazon.com. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sortButton= driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']"));
        sortButton.click();

        WebElement lowToHigh = driver.findElement(By.xpath("//a[contains(text(),'Price: Low to High')]"));
        lowToHigh.click();
        WebElement nutella = driver.findElement(By.xpath("//span[contains(text(),'Nutella B-ready (44g (Pack of 3))')]"));
        nutella.click();

        WebElement addToCard= driver.findElement(By.cssSelector("input#add-to-cart-button"));
        addToCard.click();

        WebElement cardInside = driver.findElement(By.xpath("//a[@class='nav-a nav-a-2 nav-progressive-attribute']"));
        cardInside.click();

        //WebElement Select = driver.findElement(By.xpath("//select[@name='quantity']"));
        Select quantity = new Select(driver.findElement(By.xpath("//select[@class='a-native-dropdown a-declarative sc-update-quantity-select']")));
        quantity.selectByValue("4");

        WebElement checkout = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
        checkout.click();
    }
}
