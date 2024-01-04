package AndroidTests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicFunctionality extends BaseTest {

    @Test
    public void sampleInvokeDriver() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) firstImage).getId(), "direction", "left", "percent", 0.75));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");


    }

    @Test
    public void longPress() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        driver.findElement(By.xpath("//*[@text='People Names']")).click();
        WebElement element = driver.findElement(By.xpath("//*[@text='Barry']"));
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element)
                .getId(), "duration", 2000));
        Thread.sleep(1000);
    }

    @Test
    public void scrollProgram() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Spinner\"));"));
        //	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"));"));

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"));"));
    }

    @Test
    public void dragNDrop() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement objectToDrag = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.
                of("elementId", ((RemoteWebElement) objectToDrag).getId(), "endX", 354, "endY", 320));
//        ((JavascriptExecutor)driver).executeScript("mobile: dragGesture",ImmutableMap.of("elementId",
//                ((RemoteWebElement)objectToDrag).getId(),"endX",354,"endY",320));
        String dropConfirmation = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(dropConfirmation, "Dropped!");

    }

    @Test
    public void landScape() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        driver.rotate(landScape);
        WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) firstImage).getId(), "direction", "left", "percent", 0.75));
        Assert.assertEquals(firstImage.getAttribute("focusable"), "false");

    }

    @Test
    public void keyEvents() {

        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.ApiDemos");
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

//        driver.setClipboardText("Prasanth");
//        driver.findElement(By.id("")).sendKeys(driver.getClipboardText());
    }


}
