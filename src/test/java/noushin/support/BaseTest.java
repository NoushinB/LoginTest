package noushin.support;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import noushin.page.LoginPage;
import noushin.utils.AppiumUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest extends AppiumUtils {
    public AndroidDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void configureAppium() throws IOException {
        AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(
                new File(
                        "C:\\Users\\96475\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
                )).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("D:\\maven\\loginTest\\src\\test\\resources\\noushin_login_test.apk")
                .setDeviceName("NoushinEm")
                .setChromedriverExecutable("D:\\drivers\\chromedriver_83_0_4103\\chromedriver.exe");

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage=new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
        // service.stop();
    }
}
