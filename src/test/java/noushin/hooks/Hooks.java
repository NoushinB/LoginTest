package noushin.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import noushin.core.drivers.DriverManager;
import noushin.core.drivers.DriverProvider;
import noushin.core.library.Constants;
import noushin.core.library.PropertyLoader;

public class Hooks {

    /**
     * BeforeAll hooks run before all and one time.
     * For example if we want to download the app from server we can use this.
     */
    @BeforeAll
    public static void setup() {
        PropertyLoader.getInstance().setPlatform(Constants.Platforms.ANDROID);
        PropertyLoader.getInstance().setAppPath(Constants.Apps.ANDROID);
    }

    /**
     * Before hooks run before the first step of each scenario.
     */
    @Before
    public static void beforeTest() {
        DriverProvider driverProvider = new DriverProvider();
        DriverManager.setDriver(driverProvider.getDriver());
    }

    /**
     * After hooks run after the last step of each scenario,
     * even when the step result is failed, undefined, pending, or skipped.
     */
    @After
    public static void afterTest() {
        DriverManager.removeDriver();
    }

    @AfterAll
    public static void tearDown() {

    }
}
