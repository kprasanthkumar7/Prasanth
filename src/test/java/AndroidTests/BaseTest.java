package AndroidTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;
import io.appium.java_client.android.Activity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass

    public void configAppium() throws IOException {


        service = new
                AppiumServiceBuilder().
                withAppiumJS(new File("C:\\Users\\Pavan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();options.setApp("C:\\Users\\Pavan\\IdeaProjects\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
       options.setApp("C:\\Users\\Pavan\\IdeaProjects\\Appium\\src\\test\\java\\resources\\General-Store.apk");
        options.setDeviceName("12fd212");
        options.setChromedriverExecutable("C:\\Users\\Pavan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        options.setCapability("browserName","Chrome");
        options.setCapability("appActivity","com.androidsample.generalstore.CartActivity");
        options.setCapability("appPackage", "com.androidsample.generalstore");
        driver = new AndroidDriver(new URL(" http://127.0.0.1:4723"), options);
        // Assuming 'driver' is an instance of AppiumDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Pavan\\IdeaProjects\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk")).withIPAddress("127.0.0.1").usingPort(4723).build();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }

}
