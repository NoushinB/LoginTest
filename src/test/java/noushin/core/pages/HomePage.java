package noushin.core.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import noushin.core.pages.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    private static final int DEFAULT_TIMEOUT = 20;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"home_title\")")
    private WebElement home_page_title;

    /**
     * Checks if the Home Page is displayed by verifying the visibility of the home page title.
     * 
     * @return true if the home page title is displayed; false otherwise.
     */
    public boolean isHomePageDisplayed() {
        try {
            return reusableUIMethods.isElementDisplayed(home_page_title);
        } catch (NoSuchElementException e) {
            logger.error("Home page title element not found: ", e);
            return false;
        } catch (Exception e) {
            logger.error("Unexpected error while checking if Home Page is displayed: ", e);
            return false;
        }
    }

    /**
     * Gets the title of the Home Page if it is available.
     * 
     * @return the text of the home page title if available; null otherwise.
     */
    public String getHomePageTitle() {
        try {
            boolean isAvailable = reusableUIMethods.waitForWebElementToBeAvailable(home_page_title, DEFAULT_TIMEOUT);
            if (isAvailable) {
                String titleText = home_page_title.getText();
                if (titleText != null && !titleText.isEmpty()) {
                    return titleText;
                } else {
                    logger.warn("Home page title is available but contains no text.");
                    return "";
                }
            } else {
                logger.warn("Home page title element was not available within the timeout.");
                return null;
            }
        } catch (NoSuchElementException e) {
            logger.error("Home page title element not found: ", e);
            return null;
        } catch (Exception e) {
            logger.error("Unexpected error while retrieving the Home Page title: ", e);
            return null;
        }
    }
}
