package Pageobjects.Android;

import Pageobjects.AbstractPage.AbstractClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CartPage extends AbstractClass {

    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = " //*[@resource-id='com.androidsample.generalstore:id/productName']")
    private List<WebElement> cartProducts;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsAndConditions;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/alertTitle")
    private WebElement alertTitle;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement alertClose;
    @AndroidFindBy(id ="com.androidsample.generalstore:id/btnProceed")
    private WebElement navigateToChromeButton;

    @AndroidFindBy(className = "android.widget.CheckBox")
    private WebElement checkBoxInCartPage;

    public void confirmCartItems() {


        for (int i = 0; i < cartProducts.size(); i++) {
            String productName = cartProducts.get(i).getText();
            if (productName.contains("Jordan 6 Rings")) {
                System.out.println("Products are confirmed");
            }

        }
    }
    public void checkoutAndNavigateToBrowser(){
        checkBoxInCartPage.click();
        longClickOnElement(termsAndConditions, 2000);
        waitAndCheckElementPresence(alertTitle,5);
        alertClose.click();
        navigateToChromeButton.click();

    }


}
