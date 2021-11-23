package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUpload extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        File file = new File("src/test/main/resources/лиса и мальчик.jpg");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        wait.until(ExpectedConditions.textToBe(By.id("uploaded-files"), "лиса и мальчик.jpg"));
        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(fileName.getText(), "лиса и мальчик.jpg");
    }
}



