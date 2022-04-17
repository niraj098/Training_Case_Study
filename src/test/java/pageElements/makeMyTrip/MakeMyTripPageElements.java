package pageElements.makeMyTrip;

import org.openqa.selenium.By;

public class MakeMyTripPageElements {

    public static By outsideModal= By.xpath("//div[@data-cy='outsideModal']");
    public static By fromCity= By.xpath("//input[@data-cy='fromCity']");
    public static By fromCityTextBox= By.xpath("//input[@placeholder='From']");
    public static By toCity= By.xpath("//input[@data-cy='toCity']");
    public static By toCityTextBox= By.xpath("//input[@placeholder='To']");
    public static By departureDate= By.xpath("//p[@data-cy='departureDate']");
    public static By selectDepartureDate= By.xpath("//div[@aria-label='Fri May 20 2022']");
    public static By searchButton = By.xpath("//a[contains(text(),'Search')]");
    public static By paylaterButton = By.xpath("//button[contains(text(),'OKAY, GOT IT!')]");
    public static By viewPricesButton = By.xpath("//span[contains(text(),'View Prices')]");
    public static By bookNowButton= By.xpath("//button[contains(text(),'Book Now')]");
    public static By declineSecureRadioButton=By.xpath("//span[contains(text(),'I do not wish to secure')]/../span");
    public static By addNewAdultButton = By.xpath("//button[contains(text(),'ADD NEW ADULT')]");
    public static By firstNameTextBox= By.xpath("//input[@placeholder='First & Middle Name']");
    public static By lastNameTextBox= By.xpath("//input[@placeholder='Last Name']");
    public static By maleRadioButton= By.xpath("//div[@class='selectTab ']//label");
    public static By mobileNumberTextBox= By.xpath("//input[@placeholder='Mobile No']");
    public static By emailTextBox= By.xpath("//input[@placeholder='Email']");
    public static By continueButton= By.xpath("//button[contains(text(),'Continue')]");
    public static By confirmButton= By.xpath("//button[contains(text(),'CONFIRM')]");
    public static By reviewAddOns= By.xpath("//button[@class='reviewAddonsBtn']");
    public static By proceedToPay= By.xpath("//button[contains(text(),'Proceed to pay')]");
    public static By payNowButton = By.xpath("//span[contains(text(),'pay now')]");
    public static By selectDefaultSeat= By.xpath("//button[contains(text(),'Yes, Please')]");


}
