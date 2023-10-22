package noushin.core.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import noushin.core.pages.common.BasePage;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"forgot_pass_title\")")
    private WebElement forgot_pass_title;

    public boolean isForgotPasswordPageDisplayed() {
        return reusableUIMethods.isElementDisplayed(forgot_pass_title);
    }
}
