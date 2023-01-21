package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utulities.ConfigurationReader;
import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {
   /*
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #4: Google search
        // 1- Open a chrome browser

        // We are getting the browserType dynamically from our configuration.properties file
        String browserType= ConfigurationReader.getProperty("browser");
        driver=WebDriverFactory.getDriver(browserType);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    */


    @Test
    public void google_search_test(){
        // 2- Go to: https://google.com
        Driver.getDriver().get("https://google.com");

        // 3- Write “apple” in search box
        WebElement searchbox= Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        searchbox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);
    // 4- Verify title:
    // Expected: apple - Google'da Ara
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Google'da Ara";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

//Use `configuration.properties` for the following:
// 1. The browser type
// 2. The URL
// 3. The search keyword
// 4. Make title verification dynamic.
// If search value changes, title assertion should not fail.


}

