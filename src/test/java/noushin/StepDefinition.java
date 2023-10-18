package noushin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

    @Given("the user is on the login page")
    public void userIsOnTheLoginPage() {

    }

    @When("they enter a valid username and password")
    public void enterValidUsernameAndPassword() {
    }

    @When("they click the login button")
    public void clickLoginButton() {
    }

    @Then("they should be logged in")
    public void verifyLogedin() {
    }

    @When("they enter an invalid username and password")
    public void interInvalidCredentials() {
    }

    @Then("they should see an error message")
    public void verifyErrorMessage() {
    }

    @When("they click the \"Forgot Password\" button")
    public void clickForgotPasswordButton() {

    }

    @Then("they should be taken to the password recovery page")
    public void verifyPasswordRecoveryPage() {

    }
}
