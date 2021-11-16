package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUpload extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        /*File file = new File ("/Users/ekaterinabaranova/Documents/Homework Kate_Selenium Advanced/src/main/1500478632132917686.jpeg")
        File.getAbsolutePath();*/
        chooseFileButton.sendKeys("/Users/ekaterinabaranova/Documents/Homework Kate_Selenium Advanced/src/main/1500478632132917686.jpeg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement file = driver.findElement(By.id("uploaded-files"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploaded-files")));
        Assert.assertEquals(file.getText(), "1500478632132917686.jpeg");
    }
}
