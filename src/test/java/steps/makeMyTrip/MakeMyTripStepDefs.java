package steps.makeMyTrip;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageElements.makeMyTrip.MakeMyTripPageElements;

import java.util.ArrayList;
import java.util.Locale;

import static pageElements.amazon.AmazonPageElements.*;
import static pageElements.makeMyTrip.MakeMyTripPageElements.*;
import static pageElements.makeMyTrip.MakeMyTripPageElements.continueButton;
import static pageElements.myntra.MyntraPageElements.placeOrder;


public class MakeMyTripStepDefs extends BaseClass {

    @Given("Launch MakeMyTrip Website")
    public void launchAmazonWebsite() {
        driver.get("https://www.makemytrip.com/");
        String strTitle = driver.getTitle();
        Assert.assertTrue(strTitle.toLowerCase().contains("makemytrip"));
    }

    @And("User selects from {string}")
    public void userSelectsFrom(String city) throws InterruptedException {
        driver.findElement(outsideModal).click();
        wait.until(ExpectedConditions.elementToBeClickable(fromCity));
        driver.findElement(fromCity).click();
        wait.until(ExpectedConditions.elementToBeClickable(fromCityTextBox));
        WebElement fromCityTxtBox= driver.findElement(fromCityTextBox);
        fromCityTxtBox.sendKeys(city);
        Thread.sleep(2000);
        fromCityTxtBox.sendKeys(Keys.ARROW_DOWN);
        fromCityTxtBox.sendKeys(Keys.ENTER);
    }

    @And("User selects to {string}")
    public void userSelectsTo(String city) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(toCity));
        WebElement toCityDropDown =driver.findElement(toCity);
        js.executeScript("arguments[0].click();", toCityDropDown);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(toCityTextBox));
        WebElement toCityTxtBox= driver.findElement(toCityTextBox);
        toCityTxtBox.sendKeys(city);
        Thread.sleep(2000);
        toCityTxtBox.sendKeys(Keys.ARROW_DOWN);
        toCityTxtBox.sendKeys(Keys.ENTER);
    }

    @And("User selects {string}")
    public void userSelects(String date) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(departureDate));
        js.executeScript("arguments[0].click();", driver.findElement(departureDate));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(getDepartureDate(date)));
        driver.findElement(getDepartureDate(date)).click();
    }

    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }

    @And("User click on book now button")
    public void userClickOnBookNowButton() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(paylaterButton));
            driver.findElement(paylaterButton).click();
        }catch (Exception e){}
        wait.until(ExpectedConditions.elementToBeClickable(viewPricesButton));
        driver.findElement(viewPricesButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));
        driver.findElement(bookNowButton).click();
    }

    @And("User select radio button not to opt for secure trip")
    public void userSelectRadioButtonNotToOptForSecureTrip() throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.elementToBeClickable(declineSecureRadioButton));
        WebElement radioButton =driver.findElement(declineSecureRadioButton);
        js.executeScript("arguments[0].click();", radioButton);
        Thread.sleep(5000);
    }


    @And("User clicks Add new Adult Button")
    public void userClicksAddNewAdultButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addNewAdultButton));
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(addNewAdultButton));
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", driver.findElement(addNewAdultButton));
    }

    @And("User enters passenger informations - {string}, {string}, {string}, {string}")
    public void userEntersPassengerInformations(String firstName, String lastName, String mobileNumber, String email) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameTextBox));
        driver.findElement(firstNameTextBox).sendKeys(firstName);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameTextBox));
        driver.findElement(lastNameTextBox).sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(maleRadioButton));
        driver.findElement(maleRadioButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(mobileNumberTextBox));
        driver.findElement(mobileNumberTextBox).sendKeys(mobileNumber);
        wait.until(ExpectedConditions.elementToBeClickable(emailTextBox));
        driver.findElement(emailTextBox).sendKeys(email);
        driver.findElement(emailTextBox).sendKeys(Keys.TAB);

    }

    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        js.executeScript("arguments[0].click();", driver.findElement(continueButton));
    }


    @And("User confirms details")
    public void userConfirmsDetails() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        js.executeScript("arguments[0].click();", driver.findElement(confirmButton));
    }

    @And("User review AddOns")
    public void userReviewAddOns() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewAddOns));
        js.executeScript("arguments[0].click();", driver.findElement(reviewAddOns));
    }

    @When("User clicks Proceed to pay button")
    public void userClicksProceedToPay() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.elementToBeClickable(proceedToPay));
        WebElement proceedButton =driver.findElement(proceedToPay);
        js.executeScript("arguments[0].click();", proceedButton);
    }

    @Then("User must be displayed with payment options with Pay Now Button")
    public void userMustBeDisplayedWithPaymentOptionsWithPayNowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(payNowButton));
        Assert.assertTrue(driver.findElement(payNowButton).isDisplayed(),"Pay Now Button must be displayed");
    }

    @And("User selects seats")
    public void userSelectsSeats() {
        wait.until(ExpectedConditions.elementToBeClickable(selectDefaultSeat));
        driver.findElement(selectDefaultSeat).click();
    }
}