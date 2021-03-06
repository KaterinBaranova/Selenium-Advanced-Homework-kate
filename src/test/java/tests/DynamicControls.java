package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls extends BaseTest {


    @Test
    public void addRemoveCheckboxTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement checkbox = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkbox.click();
        WebElement removeButton = driver.findElement(By.xpath("//*[@id='checkbox-example']/descendant::button[@type='button']"));
        removeButton.click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#message"), "It's gone!"));
        removeButton.click(); // remove button becomes add button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#message"), "It's back!"));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "It's back!");
    }




        @Test
        public void enableDisableTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement enableDisableButton = driver.findElement(By.xpath("//*[@id='input-example']/descendant::button[@type='button']"));
        enableDisableButton.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='input-example']/descendant::button[@type='button']"), "Disable"));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#message"), "It's enabled!"));
        enableDisableButton.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='input-example']/descendant::button[@type='button']"), "Enable"));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#message"), "It's disabled!"));
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(), "It's disabled!");
        Assert.assertEquals(enableDisableButton.getText(), "Enable");
    }
}


