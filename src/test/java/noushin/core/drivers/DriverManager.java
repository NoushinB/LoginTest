package noushin.core.drivers;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driverThread = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driverThread.get();
    }

    public static void setDriver(AppiumDriver appiumDriver) {
        driverThread.set(appiumDriver);
    }

    public static void removeDriver() {
        AppiumDriver driver = getDriver();

        if (driver != null) {
            driver.quit();
            driverThread.remove();
        }
    }
}
