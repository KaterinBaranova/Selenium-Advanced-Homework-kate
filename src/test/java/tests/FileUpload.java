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
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        File file = new File ("/Users/ekaterinabaranova/Documents/Homework Kate_Selenium Advanced/src/main/1500478632132917686.jpeg");
        file.getAbsolutePath();
        chooseFileButton.sendKeys("/Users/ekaterinabaranova/Documents/Homework Kate_Selenium Advanced/src/main/1500478632132917686.jpeg");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement fileUploaded = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded!']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'File Uploaded!']")));
        Assert.assertEquals(fileUploaded.getText(), "File Uploaded!");
    }
}

