package noushin.core.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import noushin.core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "toolbar_title")
    private WebElement loginToolbarTitle;

    @AndroidFindBy(id = "login_username")
    private WebElement txtUsername;
    @AndroidFindBy(id = "login_password")
    private WebElement txtPassword;
    @AndroidFindBy(id = "login_button")
    private WebElement btnLogin;

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
}
