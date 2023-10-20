package noushin.steps.common;

import io.appium.java_client.AppiumDriver;
import noushin.core.drivers.DriverManager;

public class BaseSteps {
    public AppiumDriver appiumDriver;

    public BaseSteps() {
        this.appiumDriver = DriverManager.getDriver();
    }
}
