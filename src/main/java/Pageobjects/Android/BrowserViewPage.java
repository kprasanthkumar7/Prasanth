package Pageobjects.Android;

import Pageobjects.AbstractPage.AbstractClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;


public class BrowserViewPage extends AbstractClass {

    AndroidDriver driver;

    public BrowserViewPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

  //  @AndroidFindBy




    public void browserActions(){

      //  options.setCapability("appActivity", "com.example.app.TargetActivity");
        Set<String> browserHandles = driver.getContextHandles();

        for(String currentHandles:browserHandles)
        {
            System.out.println(currentHandles);
        }
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

    }

   // com.androidsample.generalstore/com.androidsample.generalstore.CartActivity



}
