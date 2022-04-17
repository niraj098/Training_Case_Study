package steps.myntra;

import base.BaseClass;
import cucumber.api.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;

import static pageElements.myntra.MyntraPageElements.*;

public class MyntraStepDefs extends BaseClass {

    @Given("Launch Myntra Website")
    public void launchMyntraWebsite() {
        driver.get("https://www.myntra.com/");
        String strTitle = driver.getTitle();
        Assert.assertTrue(strTitle.contains("Online Shopping"));
    }

    @And("User clicks on 'profile' icon")
    public void userClicksOnProfileIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
        driver.findElement(profileIcon).click();
    }

    @And("User click on 'login or signup' button")
    public void userClickOnLoginOrSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }

    @And("User enters valid username")
    public void userEntersValidUsername() {
        wait.until(ExpectedConditions.elementToBeClickable(userNameTextBox));
        driver.findElement(userNameTextBox).sendKeys("8122371136");
    }

    @And("User clicks on 'continue' button")
    public void userClicksOnContinueButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
        Thread.sleep(26000);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        driver.findElement(continueButton).click();
    }

    @And("User clicks on 'Login using password' link")
    public void userClicksOnLoginUsingPasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginUsingPassword));
        driver.findElement(loginUsingPassword).click();
    }

    @And("User enters invalid password")
    public void userEntersInvalidPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(paswordTextBox));
        driver.findElement(paswordTextBox).sendKeys("invalid password");
    }

    @When("User clicks on 'login' button")
    public void userClicksOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Then("User should be displayed with proper notification")
    public void userShouldBeDisplayedWithProperNotification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginNotification));
        String invalidNotificationText= driver.findElement(invalidLoginNotification).getText();
        Assert.assertTrue(invalidNotificationText.contains("Incorrect phone number or password"),"Proper Notification must be displayed");
    }

    @And("User searches for {string} in the main searchbox")
    public void userSearchesForInTheMainSearchbox(String product) {
        wait.until(ExpectedConditions.elementToBeClickable(searchTextBox));
        WebElement srchTextBox= driver.findElement(searchTextBox);
        srchTextBox.sendKeys(product);
        srchTextBox.sendKeys(Keys.ENTER);
    }

    @And("User must be displayed with relevant search results for {string}")
    public void userMustBeDisplayedWithRelevantSearchResultsFor(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        String searchResultText= driver.findElement(searchResult).getText().toLowerCase();
        Assert.assertTrue(searchResultText.contains(product),"Relevant search result must be displayed");
    }

    @And("User clicks on first search result")
    public void userClicksOnFirstSearchResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResult));
        driver.findElement(firstSearchResult).click();
    }

    @And("User clicks on 'Add to Bag' button")
    public void userClicksOnAddToBagButton() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        driver.findElement(addToBagButton).click();
    }

    @And("User clicks on 'Go to Bag' button")
    public void userClicksOnGoToBagButton() {
        wait.until(ExpectedConditions.elementToBeClickable(goToBagButton));
        driver.findElement(goToBagButton).click();
    }

    @When("User clicks on 'Place Order' link")
    public void userClicksOnPlaceOrderLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder));
        WebElement placeOrderButton =driver.findElement(placeOrder);
        js.executeScript("arguments[0].click();", placeOrderButton);
    }

    @Then("User must be redirected to login page")
    public void userMustBeRedirectedToLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
        String LoginText = driver.findElement(welcomeText).getText();
        Assert.assertTrue(LoginText.contains("Login"),"Login Page must be displayed");
    }

}
