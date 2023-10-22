package noushin.steps.android.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import noushin.core.pages.ForgotPasswordPage;
import noushin.core.pages.HomePage;
import noushin.core.pages.LoginPage;

import static org.junit.Assert.*;

public class LoginSteps {

    private final LoginPage loginPage;
    private final HomePage homePage;
    private final ForgotPasswordPage forgotPasswordPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        forgotPasswordPage = new ForgotPasswordPage();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("they enter a valid username and password")
    public void they_enter_a_valid_username_and_password() {
        loginPage.setUsernameField("noushin");
        loginPage.setPasswordField("1234");
    }

    @When("they click the login button")
    public void they_click_the_login_button() {
        loginPage.login();
    }

    @Then("they should be logged in")
    public void they_should_be_logged_in() {
        assertTrue(homePage.isHomePageDisplayed());
        assertEquals("Hello Noushin!", homePage.getHomePageTitle());
    }

    @When("they enter an invalid username and password")
    public void they_enter_an_invalid_username_and_password() {
        loginPage.setUsernameField("noushin1");
        loginPage.setPasswordField("1234");
    }

    @Then("they should see an error message")
    public void they_should_see_an_error_message() {
        assertEquals("Username is not valid", loginPage.getErrorText());
    }

    @When("they click the Forgot Password button")
    public void they_click_the_button() {
        loginPage.forgotPasswordButtonClick();
    }

    @Then("they should be taken to the password recovery page")
    public void they_should_be_taken_to_the_password_recovery_page() {
        assertTrue(forgotPasswordPage.isForgotPasswordPageDisplayed());
    }
}
