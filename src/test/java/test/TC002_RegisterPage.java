package test;

import base.TestBased;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePages;
import pages.RegisterPages;
import retry.Retry;

import static pages.WaitPages.waitForPageLoad;

public class TC002_RegisterPage extends TestBased {
    @Parameters("browser")
    @Description("Customer wants to open Register Page")
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void openRegisterPage() throws InterruptedException {
        waitForPageLoad(driver);
        String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : properties.getProperty("browser");
        switch (browser.toLowerCase()) {
            case "firefox":
                new HomePages(driver).clickExitLoginGoogleNofiticationBtn();
                new HomePages(driver).clickRegisterBtn();
                new RegisterPages(driver).title_Register_page();
                break;
            default:
                new HomePages(driver).clickRegisterBtn();
                new RegisterPages(driver).title_Register_page();
                break;
        }

    }
}
