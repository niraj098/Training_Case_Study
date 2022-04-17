package pageElements.amazon;

import org.openqa.selenium.By;

public class AmazonPageElements {

    public static By signInButton = By.xpath("//div[@id='nav-signin-tooltip']//span[(text()='Sign in')]");
    public static By userNameTextBox= By.xpath("//input[@id='ap_email']");
    public static By continueButton=By.xpath("//input[@type='submit']");
    public static By passwordTextBox=By.xpath("//input[@type='password']");
    public static By submitButton=By.xpath("//input[@type='submit']");
    public static By invalidPwdErrorMessage = By.xpath("//div[@id='auth-error-message-box']");
    public static By searchBox=By.xpath("//input[@id='twotabsearchtextbox']");
    public static By searchResult=By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']");
    public static By firstSearchResult= By.xpath("//div[@data-component-type='s-search-result']//h2[contains(@class,'clamp-2')]/a");
    public static By mRPText= By.xpath("//span[contains(@class,'basisPrice') and contains(@class,'secondary')]");
    public static By buyNowButton=By.xpath("//input[@id='buy-now-button']");
    public static By signInText = By.xpath("//h1[@class='a-spacing-small']");
}
