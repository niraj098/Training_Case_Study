package base;

import cucumber.api.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public BaseClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait =  new WebDriverWait(driver,30);
        js = (JavascriptExecutor) driver;
    }
}
