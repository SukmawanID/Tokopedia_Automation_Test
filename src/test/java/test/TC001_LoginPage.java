package test;
import jdk.jfr.Description;
import org.bouncycastle.oer.Switch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePages;
import base.TestBased;
import pages.LoginPages;
import retry.Retry;

import java.time.Duration;

import static pages.WaitPages.waitForPageLoad;

public class TC001_LoginPage extends TestBased {
    @Parameters("browser")
    @Description("Customer wants to open Login Page")
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void openLoginPage() throws InterruptedException {
        waitForPageLoad(driver);
        new HomePages(driver).clickLoginBtn();
        new LoginPages(driver).title_Login_page();
        new LoginPages(driver).clickExitLoginBtn();
    }
}
