import base.BaseClass;
import cucumber.api.java.After;

import static base.BaseClass.driver;


public class Hooks  {

    @After
    public void after(){
        driver.quit();
    }
}
