package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ContextMenu extends BaseTest {


    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    @Test
    public void addCheckCloseAlert() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        Assert.assertTrue(isAlertPresent());
        Alert alert = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent()));
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.dismiss();
    }
}

