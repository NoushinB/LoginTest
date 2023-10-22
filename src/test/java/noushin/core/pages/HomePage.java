package noushin.core.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import noushin.core.pages.common.BasePage;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"home_title\")")
    private WebElement home_page_title;

    public boolean isHomePageDisplayed() {
        return reusableUIMethods.isElementDisplayed(home_page_title);
    }

    public String getHomePageTitle() {
        boolean isAvailable = reusableUIMethods.waitForWebElementToBeAvailable(home_page_title, 20);
        if (isAvailable) {
            return home_page_title.getText();
        }
        return null;
    }
}
