package steps;
import Util.Util;
import io.cucumber.java.en.Given;
import org.junit.Assert;


public class AmazonStepDefs extends Util {

    @Given("Launch Amazon Website")
    public void launchAmazonWebsite() {
        driver.get("https://www.amazon.in/");
        String strTitle = driver.getTitle();
        Assert.assertTrue(strTitle.contains("Online Shopping"));
        driver.quit();
    }

}