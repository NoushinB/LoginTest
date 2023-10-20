package noushin.core.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import noushin.core.library.Constants;
import noushin.core.library.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverProvider {
    private AppiumDriver driver;
    private final PropertyLoader properties = PropertyLoader.getInstance();

    public AppiumDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private void initializeDriver() {
        try {
            if (properties.getPlatform().equalsIgnoreCase(Constants.Platforms.ANDROID)) {
                initializeAndroidDriver();
            } else {
                initializeIosDriver();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private void initializeAndroidDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp(properties.getAppPath());
        options.setDeviceName("NoushinEm");
        options.setNewCommandTimeout(Duration.ofSeconds(120));
        options.autoGrantPermissions();
        options.setChromedriverExecutable("D:\\drivers\\chromedriver_83_0_4103\\chromedriver.exe");

        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, options);
    }

    private void initializeIosDriver() throws MalformedURLException {
        // TODO: Initialize iOS Driver
    }
}

