package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ActionChains actionChains;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actionChains = new ActionChains(driver);

    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
}
}
