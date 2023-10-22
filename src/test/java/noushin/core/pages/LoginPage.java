package noushin.core.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import noushin.core.pages.common.BasePage;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_toolbar_title\")")
    private WebElement loginToolbarTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_username\")")
    private WebElement txtUsername;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_password\")")
    private WebElement txtPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_button\")")
    private WebElement btnLogin;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_error\")")
    private WebElement errorMessage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"forgot_pass_button\")")
    private WebElement forgotPasswordButton;

    public boolean isLoginPageDisplayed() {
        return reusableUIMethods.isElementDisplayed(loginToolbarTitle);
    }

    public void setUsernameField(String userName) {
        txtUsername.sendKeys(userName);
        hideKeyboard();
    }

    public void setPasswordField(String password) {
        txtPassword.sendKeys(password);
        hideKeyboard();
    }

    public void login() {
        btnLogin.click();
    }

    public String getErrorText() {
        boolean isAvailable = reusableUIMethods.waitForWebElementToBeAvailable(errorMessage, 5);
        if (isAvailable) {
            return errorMessage.getText();
        }
        return "";
    }

    public void forgotPasswordButtonClick() {
        forgotPasswordButton.click();
    }
}
