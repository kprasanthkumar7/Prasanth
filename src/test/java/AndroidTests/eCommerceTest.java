package AndroidTests;

import Pageobjects.Android.CartPage;
import Pageobjects.Android.LandingPage;
import Pageobjects.Android.ListingsPage;
import io.appium.java_client.android.Activity;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class eCommerceTest extends BaseTest {
    private CartPage cartPage;
    private LandingPage landingPage;
    private ListingsPage listingsPage;

    @BeforeClass
    public void eCommerceClasses() {
        cartPage = new CartPage(driver);
        landingPage = new LandingPage(driver);
        listingsPage = new ListingsPage(driver);
    }
    @BeforeMethod
    public void loginActivity(){

      Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
      activity.getAppActivity();

    }
    @Test(priority = 0)
    public void mobileBrowser() {

        landingPage.errorLogin();

        //driver.get("https://rahulshettyacademy.com/angularAppdemo/");

    }
    @Test(priority = 1)
    public void eCommerceTestcase() {
        landingPage.login();
        listingsPage.selectItemFromListingsAndNavigateToCart();
        cartPage.confirmCartItems();
        cartPage.checkoutAndNavigateToBrowser();
        Set<String> browserHandles = driver.getContextHandles();

        for (String currentHandles : browserHandles) {
            System.out.println(currentHandles);
        }


    }


////        driver.findElement(By.id("android:id/text1")).click();
////        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));")).click();
//        //  driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        //   String toastMsg = driver.findElement(By.xpath("//android.widget.Toast[@text=\"Please enter your name\"]")).getText();
//        //  Assert.assertEquals(toastMsg, "Please enter your name");
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Prasanth");
//        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        String listingsPage = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
//        Assert.assertEquals(listingsPage, "Products");
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
//        int products = driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productName']")).size();
//        for (int i = 0; i < products; i++) {
//            String productName = driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productName']")).get(i)
//                    .getText();
//
//            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
//                driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
//            }
//
//
//        }
//        String productConfirmation = driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).getText();
//        Assert.assertEquals(productConfirmation, "ADDED TO CART");
    //     driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        String cartPageConfirm = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText();
//        Assert.assertEquals(cartPageConfirm, "Cart");
//        List<WebElement> prices = driver.findElements(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productPrice']"));
//       // List<String> price = prices.stream().map(s -> s.getText().split("$")).map(s -> s.length > 1 ? s[1] : s[0]).collect(Collectors.toList());
//        double sum =0;
//       for(int i=0;i<prices.size();i++)
//       {
//           String productsPrice =prices.get(i).getText();
//           double productPrice = Double.parseDouble(productsPrice.substring(1));
//           sum =sum +productPrice;
//       }

//        String totalPriceConfirmation = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
//
//        double totPriceConfirm=Double.parseDouble(totalPriceConfirmation);
//
//        Assert.assertEquals(totPriceConfirm,sum);


    // driver.findElement(By.className("android.widget.CheckBox")).click();

    //*[@resource-id='com.androidsample.generalstore:id/productName']
//        WebElement longPressTerms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//
//        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) longPressTerms).getId(), "duration", 2000));
//        String termsMsgConfirm = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
//        Assert.assertEquals(termsMsgConfirm, "Terms Of Conditions");
//        driver.findElement(By.id("android:id/button1")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();


}
