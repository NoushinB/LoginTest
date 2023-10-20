package noushin.core.library;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class is to define reusable methods that are related to UI, and they need a driver
 */
public class ReusableUIMethods {
    protected final AppiumDriver driver;

    public ReusableUIMethods(AppiumDriver driver) {
        this.driver = driver;
    }

    public void longPressAction(WebElement ele) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
    }

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
                    .of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
        } while (canScrollMore);
    }

    public void scrollToText(String text) {
        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void swipeDirection(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
    }

    public boolean waitForTextToBeAvailable(By selector, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        boolean isAvailable;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            isAvailable = true;
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            isAvailable = false;
        }

        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT);
        return isAvailable;
    }

    public boolean waitForWebElementToBeAvailable(WebElement element, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        boolean isAvailable;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            isAvailable = true;
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            isAvailable = false;
        }

        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT);
        return isAvailable;
    }
}
