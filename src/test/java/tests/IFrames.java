package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrames extends BaseTest {

    @Test
    public void iFramesTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        WebElement iframeLink = driver.findElement(By.xpath("//li/following::a[@href='/iframe']"));
        iframeLink.click();
        WebElement iFrame= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement text = driver.findElement(By.cssSelector("body[id='tinymce']"));
        Assert.assertEquals(text.getText(),"Your content goes here.");
        driver.switchTo().defaultContent();
    }
}
