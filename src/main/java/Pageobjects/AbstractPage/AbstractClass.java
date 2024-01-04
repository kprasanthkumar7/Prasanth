package Pageobjects.AbstractPage;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AbstractClass {
    AndroidDriver driver;

    public AbstractClass(AndroidDriver driver) {

        this.driver = driver;
    }

    public void scrollToTheElementAndClick(String element) {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + element + "\"));")).click();

    }

    public void scrollToTheElement(String element) {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + element + "\"));"));

    }

    public void waitAndCheckElementPresence(WebElement element, int timeInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void navigateToCartPage() {
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }

    public void longClickOnElement(WebElement element, int durationInMilliSeconds) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", durationInMilliSeconds));
    }

    public String takeScreenShot(String testCase) throws IOException {


        File source =driver.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\Reports\\"+testCase+".png";
        FileUtils.copyFile(source, new File(path));

        return path;

    }
}
