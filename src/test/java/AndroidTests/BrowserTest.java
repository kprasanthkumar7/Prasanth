package AndroidTests;

import org.testng.annotations.Test;

public class BrowserTest extends BaseTestBrowser {
    @Test
    public void browser(){

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

    }

}
