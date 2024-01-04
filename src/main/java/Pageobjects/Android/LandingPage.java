package Pageobjects.Android;

import Pageobjects.AbstractPage.AbstractClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends AbstractClass {

    AndroidDriver driver;

    public LandingPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/text1")
    private WebElement selectCountryD;

//    @AndroidBy(id = "android:id/text1")
//    private WebElement selectCountryD;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letShopButton;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text=\"Please enter your name\"]")
    private WebElement landingPageToastMsg;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement landingPageTextField;

    //  driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Prasanth");

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioOpt;

    String selectCountry = "India";


    public void login() {
//        selectCountryD.click();
//        scrollToTheElementAndClick(selectCountry);
//        letShopButton.click();
//        String toastMsg = landingPageToastMsg.getText();
 //       waitAndCheckElementPresence(10);
        landingPageTextField.sendKeys("Prasanth");
        femaleRadioOpt.click();
        letShopButton.click();
    }
    public void errorLogin() {
//        selectCountryD.click();
//        scrollToTheElementAndClick(selectCountry);
        letShopButton.click();
        String toastMsg = landingPageToastMsg.getText();
        //waitAndCheckElementPresence(10);

    }

}
