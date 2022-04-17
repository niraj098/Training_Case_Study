package steps.amazon;
import cucumber.api.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.util.ArrayList;

import static pageElements.amazon.AmazonPageElements.*;



public class AmazonStepDefs extends BaseClass {

    @Given("Launch Amazon Website")
    public void launchAmazonWebsite() {
        driver.get("https://www.amazon.in/");
        String strTitle = driver.getTitle();
        Assert.assertTrue(strTitle.contains("Online Shopping"));
    }

    @When("User Clicks on 'Sign In' button")
    public void userClicksOnSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        WebElement signInBtn = driver.findElement(signInButton);
        signInBtn.click();
    }

    @And("User inputs username")
    public void userInputsUsername() {
        wait.until(ExpectedConditions.elementToBeClickable(userNameTextBox));
        WebElement userNameTxtBox= driver.findElement(userNameTextBox);
        userNameTxtBox.sendKeys("7845287511");
    }

    @And("User Clicks on continue button")
    public void userClicksOnContinueButton() {
        WebElement continueBtn= driver.findElement(continueButton);
        continueBtn.click();
    }

    @And("User inputs incorrect password and clicks submit button")
    public void userInputsIncorrectPasswordAndClicksSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
        WebElement pwdTextBox=driver.findElement(passwordTextBox);
        pwdTextBox.sendKeys("Invalid");
        WebElement signInBtn=driver.findElement(submitButton);
        signInBtn.click();
    }

    @Then("User should be displayed with proper error message")
    public void userShouldBeDisplayedWithProperErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPwdErrorMessage));
        String errorMessage= driver.findElement(invalidPwdErrorMessage).getText();
        Assert.assertTrue(errorMessage.contains("Your password is incorrect"),"ErrorMessage should be displayed");
    }

    @When("User searches for product {string}")
    public void userSearchesForProduct(String searchProduct) {
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        WebElement srchBox=driver.findElement(searchBox);
        srchBox.sendKeys(searchProduct);
        srchBox.sendKeys(Keys.ENTER);
    }

    @Then("Relevant search for corresponding {string} should be displayed")
    public void relevantSearchForCorrespondingShouldBeDisplayed(String searchProduct) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
        WebElement srchResult= driver.findElement(searchResult);
        Assert.assertTrue(srchResult.getText().contains(searchProduct),"Relevant search result is not displayed");
    }

    @And("User opens details page for first product")
    public void userOpensDetailsPageForFirstProduct() {
        WebElement firstSrchResult= driver.findElement(firstSearchResult);
        firstSrchResult.click();
    }

    @Then("User should be able to see 'MRP'")
    public void userShouldBeAbleToSeeMRP() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebElement mrpText= driver.findElement(mRPText);
        Assert.assertTrue(mrpText.getText().contains("M.R.P"),"MRP should be displayed");
    }

    @And("'Buy Now' button must be enabled")
    public void buttonMustBeEnabled() {
        WebElement buyNowBtn= driver.findElement(buyNowButton);
        Assert.assertTrue(buyNowBtn.isEnabled(),"Buy Now button should be enabled");
    }



    @And("click on 'Buy Now' Button")
    public void clickOnBuyNowButton() {
        driver.findElement(buyNowButton).click();
    }

    @And("User must be directed to login page")
    public void userMustBeDirectedToLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInText));
        String signInTextInPage = driver.findElement(signInText).getText();
        Assert.assertTrue(signInTextInPage.contains("Sign-In"),"Sign In Page is not diplayed");
    }
}