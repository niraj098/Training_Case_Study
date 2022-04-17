package pageElements.myntra;

import org.openqa.selenium.By;

public class MyntraPageElements {

    public static By profileIcon = By.xpath("//div[@class='desktop-userIconsContainer']");
    public static By loginLink= By.xpath("//a[@class='desktop-linkButton']");
    public static By userNameTextBox= By.xpath("//input[@class='form-control mobileNumberInput']");
    public static By continueButton= By.xpath("//div[@class='submitBottomOption']");
    public static String processingFrameId = "sec-text-if";
    public static By processingMessage = By.xpath("//span[@class='message-text']");
    public static By loginUsingPassword = By.xpath("//div[@class='bottomeLink']/span[contains(text(),'Password')]");
    public static By paswordTextBox= By.xpath("//input[@type='password']");
    public static By loginButton = By.xpath("//button[contains(@class,'submitButton')]");
    public static By invalidLoginNotification= By.xpath("//div[@class='notifyText']"); //Incorrect phone number or password
    public static By searchTextBox=By.xpath("//input[@placeholder='Search for products, brands and more']");
    public static By searchResult= By.xpath("//h1[@class='title-title']");
    public static By firstSearchResult= By.xpath("//ul[@class='results-base']/li//a");
    public static By addToBagButton= By.xpath("//div[contains(text(),'ADD TO BAG')]");
    public static By goToBagButton = By.xpath("//span[contains(text(),'GO TO BAG')]");
    public static By placeOrder=By.xpath("//div[contains(text(),'Place Order')]");
    public static By welcomeText=By.xpath("//div[@class='welcome-header']");

}
