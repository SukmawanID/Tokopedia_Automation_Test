package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPages extends WaitPages{

    WebDriver driver;
    //WaitPages waitPages;

    public RegisterPages(WebDriver driver) {
        this.driver = driver;
    }

    private final By title_register = By.xpath("//h1[@class='box__title']");
    public void title_Register_page() {
        try {
            WebElement titleID = shortWebDriverWait(driver).until(ExpectedConditions.visibilityOfElementLocated(title_register));
            if (titleID != null) {
                String title = titleID.getText();
                Assert.assertEquals("Daftar Sekarang", title);
            } else {
                System.out.println("Title ID is null.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
