package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;


public class FileDownload extends BaseTest {
    // tried to use info https://praveendavidmathew.medium.com/how-to-check-if-a-file-got-downloaded-in-java-selenium-tests-9e0c26597a73
    public ExpectedCondition<Boolean> filePresent() { //not sure how to use it
        return new ExpectedCondition<>() {
            @Override
            public Boolean apply(WebDriver driver) {
                File f = new File("/Users/ekaterinabaranova/Downloads/smile.jpeg");
                return f.exists();
            }

            @Override
            public String toString() {
                return "file to be present within the time specified";
            }
        };
    }

    @Test
    public void fileDownloadTest() {

        driver.get("http://the-internet.herokuapp.com/download");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement downloadLink = driver.findElement(By.cssSelector("a[href='download/smile.jpeg']"));
        downloadLink.click();
        wait.until(ExpectedConditions.filePresent()); // don't know what to write here
        boolean fileExists = Files.exists(Paths.get("/Users/ekaterinabaranova/Downloads/smile.jpeg"));
        Assert.assertTrue(fileExists);

    // info from the homework provided article: don't know how to use it

    File folder = new File(System.getProperty("/Users/ekaterinabaranova/Downloads/smile.jpeg"));
    File[] listOfFiles = folder.listFiles();
    boolean found = false;
    File f = null;
        for(File listOfFile: Objects.requireNonNull(listOfFiles)){
        if(listOfFile.isFile()){
            String fileName=listOfFile.getName();
            System.out.println("File " + listOfFile.getName());
            if(fileName.matches("smile.jpeg")){
                f=new File(fileName);
                found=true;}

        }
    }

    Assert.assertTrue(found,"Downloaded document is not found");
    f.deleteOnExit();
    }
}

