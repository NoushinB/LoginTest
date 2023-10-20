package noushin.steps.android.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import noushin.core.pages.LoginPage;
import noushin.steps.common.BaseSteps;


public class LoginSteps extends BaseSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.hideKeyboard();
    }

    @When("they enter a valid username and password")
    public void they_enter_a_valid_username_and_password() {

    }

    @When("they click the login button")
    public void they_click_the_login_button() {

    }

    @Then("they should be logged in")
    public void they_should_be_logged_in() {

    }

    @When("they enter an invalid username and password")
    public void they_enter_an_invalid_username_and_password() {

    }

    @Then("they should see an error message")
    public void they_should_see_an_error_message() {

    }

    @When("they click the {string} button")
    public void they_click_the_button(String string) {

    }

    @Then("they should be taken to the password recovery page")
    public void they_should_be_taken_to_the_password_recovery_page() {

    }
}
