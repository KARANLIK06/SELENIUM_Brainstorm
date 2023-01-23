package com.cydeo.group7Practice;

import com.cydeo.utulities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileage {
    @Test
    public void gasMileageCalculator() {


        //Task #: Gas Mileage Calculator Automation Test
        //
        //1. Add a new class GasMileageCalculatorTest
        //2. Go to https://www.calculator.net
        Driver.getDriver().get("https://www.calculator.net");

        //3. Search for “gas mileage” using search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage"+ Keys.ENTER);
        //4. Click on the “Gas Mileage Calculator” link
        WebElement linkWord = Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        linkWord.click();

        //
        //
        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        Assert.assertEquals(Driver.getDriver().getTitle(),"Gas Mileage Calculator");
        //b. “Gas Mileage Calculator” label is displayed
        WebElement gasMileageLabel= Driver.getDriver().findElement(By.xpath("//h1"));
        gasMileageLabel.isDisplayed();

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometer=Driver.getDriver().findElement(By.cssSelector("#mucodreading"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer=Driver.getDriver().findElement(By.cssSelector("#mupodreading"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded=Driver.getDriver().findElement(By.cssSelector("#mugasputin"));
        gasAdded.clear();
        gasAdded.sendKeys("16");


        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice=Driver.getDriver().findElement(By.cssSelector("#mugasprice"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");



        //10. Click on Calculate button
        WebElement calculateButton=Driver.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        calculateButton.click();
        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
        WebElement mpgValue=Driver.getDriver().findElement(By.xpath("//span[@class='bigtext']"));
        String actualmpgValue= mpgValue.getText();
        String expectedmpgValue="23.44 mpg";
        Assert.assertEquals(actualmpgValue,expectedmpgValue);

    }
}
