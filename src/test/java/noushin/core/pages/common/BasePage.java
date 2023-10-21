package noushin.core.pages.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import noushin.core.drivers.DriverManager;
import noushin.core.library.ReusableMethods;
import noushin.core.library.ReusableUIMethods;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected AppiumDriver driver;
    protected ReusableUIMethods reusableUIMethods;
    protected ReusableMethods reusableMethods;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        reusableUIMethods = new ReusableUIMethods(driver);
        reusableMethods = new ReusableMethods();
    }

    public void hideKeyboard() {
        if (reusableMethods.isAndroid()) {
            ((AndroidDriver) driver).hideKeyboard();
        } else {
            ((IOSDriver) driver).hideKeyboard();
        }
    }
}
