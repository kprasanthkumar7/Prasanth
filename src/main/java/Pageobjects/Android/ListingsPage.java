package Pageobjects.Android;

import Pageobjects.AbstractPage.AbstractClass;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ListingsPage extends AbstractClass {

    AndroidDriver driver;

    public ListingsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "android:id/text1")
    private WebElement selectCountryD;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private WebElement addedItemConfirm;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
    private WebElement addToCartButton;


    @AndroidFindBy(xpath = "//*[@resource-id='com.androidsample.generalstore:id/productName']")
    private List<WebElement> products;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement cartPageTitle;

    public void selectItemFromListingsAndNavigateToCart() {
        String productName = "Jordan 6 Rings";
        scrollToTheElement(productName);
        products.size();

        for (int i = 0; i < products.size(); i++) {
            if ((products.get(i).getText()).equalsIgnoreCase("Jordan 6 Rings")) {
                addToCartButton.click();
            }

        }
        addedItemConfirm.getText();
        navigateToCartPage();
        String cartPageConfirm = cartPageTitle.getText();

    }


}
