package pageElements.amazon;

import org.openqa.selenium.By;

public class AmazonPageElements {

    public static By signInButton = By.xpath("//div[@id='nav-signin-tooltip']//span[(text()='Sign in')]");
    public static By userNameTextBox= By.xpath("//input[@id='ap_email']");
    public static By continueButton=By.xpath("//input[@type='submit']");
    public static By passwordTextBox=By.xpath("//input[@type='password']");
    public static By submitButton=By.xpath("//input[@type='submit']");
    public static By invalidPwdErrorMessage = By.xpath("//div[@id='auth-error-message-box']");
}
