package noushin.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import noushin.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AndroidActions {
    AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "login_username")
    private WebElement txtUsername;
    @AndroidFindBy(id = "login_password")
    private WebElement txtPassword;
    @AndroidFindBy(id = "login_button")
    private WebElement btnLogin;

    public void setUsernameField(String userName) {
        txtUsername.sendKeys(userName);
        driver.hideKeyboard();
    }

    public void setPasswordField(String password) {
        txtPassword.sendKeys(password);
        driver.hideKeyboard();
    }

    public void login() {
        btnLogin.click();
    }
}
