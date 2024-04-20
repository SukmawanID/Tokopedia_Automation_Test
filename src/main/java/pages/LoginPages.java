package pages;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;



public class LoginPages extends WaitPages  {
    WebDriver driver;
    //WaitPages waitPages;

    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }

    private final By login_title_id = By.xpath("//h3[@data-unify='Typography']");

    private final By exit_login_btn = By.xpath("//button[@data-testid='modal-close']");

    public void title_Login_page() {
        try {
            WebElement titleID = shortWebDriverWait(driver).until(ExpectedConditions.visibilityOfElementLocated(login_title_id));
            if (titleID != null) {
            String title = titleID.getText();
                Assert.assertEquals("Masuk",title);
            } else {
                System.out.println("Title ID is null.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void clickExitLoginBtn() {
        try {
            WebElement exitButton = shortWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(exit_login_btn));
            if (exitButton != null) {
                exitButton.click();
            } else {
                System.out.println("Login button element is null.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

}