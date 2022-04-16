package steps.myntra;

import base.BaseClass;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class MyntraStepDefs extends BaseClass {

    @Given("Launch Myntra Website")
    public void launchMyntraWebsite() {
        driver.get("https://www.myntra.com/");
        String strTitle = driver.getTitle();
        Assert.assertTrue(strTitle.contains("Online Shopping"));
        driver.quit();
    }
}
