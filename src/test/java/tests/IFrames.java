package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class IFrames extends BaseTest {

    @Test
    public void framesTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        WebElement iframeLink = driver.findElement(By.xpath("a[@href='/iframe']"));
        iframeLink.click();
        WebElement iFrame= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement text = driver.findElement(By.cssSelector("body[id='tinymce']"));
        Assert.assertEquals(text.getText(),"Your content goes here.");
    }
}
