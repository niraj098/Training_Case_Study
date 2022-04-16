package steps.amazon;
import cucumber.api.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BaseClass;
import io.cucumber.java.en.Given;
import org.testng.Assert;

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

    @After
    public void after(){
        driver.quit();
    }
}