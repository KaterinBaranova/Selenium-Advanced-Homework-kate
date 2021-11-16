package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUpload extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys("/Users/ekaterinabaranova/Documents/Homework Kate_Selenium Advanced/src/main/1500478632132917686.jpeg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement file = driver.findElement(By.id("uploaded-files"));
        wait.until(ExpectedCondition.presenceOfElementLocated(By.id("uploaded-files")));
        Assert.assertEquals(file.getText(), "1500478632132917686.jpeg");
    }
}
