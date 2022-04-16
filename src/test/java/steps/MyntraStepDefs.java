package steps;
import Util.Util;
import io.cucumber.java.en.Given;
import org.junit.Assert;


public class MyntraStepDefs extends Util {

    @Given("Launch Myntra Website")
    public void launchMyntraWebsite() {
        driver.get("https://www.myntra.com/");
        String strTitle = driver.getTitle();
        Assert.assertTrue(strTitle.contains("Online Shopping"));
        driver.quit();
    }

}