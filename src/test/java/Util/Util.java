package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Util {
    public static WebDriver driver;

    public Util() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
