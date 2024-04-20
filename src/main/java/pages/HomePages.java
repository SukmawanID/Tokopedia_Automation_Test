package pages;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePages extends WaitPages {

    WebDriver driver;
    //WaitPages waitPages;

    public HomePages(WebDriver driver) {
        this.driver = driver;
    }

    private final By login_btn = By.xpath("//div[@class='css-vlg5ix']//button[@data-testid='btnHeaderLogin']");
    private final By register_btn = By.xpath("//div[@class='css-vlg5ix']//button[@data-testid='btnHeaderRegister']");
    private final By click_exit_login_nofitication_Btn = By.cssSelector("div[id='close']");
    private final By iframe_login_google = By.cssSelector("iframe[title='Dialog Login dengan Google']");

    public void clickExitLoginGoogleNofiticationBtn() {
        try {

            WebElement iFrameElement = driver.findElement(iframe_login_google);
            driver.switchTo().frame(iFrameElement);
            WebElement printTitle = driver.findElement(By.cssSelector("h1[id='picker-title']"));
            System.out.println("------------------|||||||||  " +  printTitle.getText()  +  "   |||||||||------------------");
            WebElement exitLoginNotifButton = shortWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(click_exit_login_nofitication_Btn));
            if (exitLoginNotifButton != null) {
                exitLoginNotifButton.click();
            } else {
                System.out.println("Login button element is null.");
            }
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void clickRegisterBtn() {
        try {
            WebElement registerButton = shortWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(register_btn));
            if (registerButton != null) {
                registerButton.click();
                Thread.sleep(1000);
            } else {
                System.out.println("Login button element is null.");
            }
            Thread.sleep(1000);
        } catch (TimeoutException e) {
            System.out.println("Timeout exception occurred: " + e.getMessage()); // Pesan spesifik untuk TimeoutException
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickLoginBtn() {
        try {
            WebElement LoginButton = shortWebDriverWait(driver).until(ExpectedConditions.elementToBeClickable(login_btn));
            if (LoginButton != null) {
                LoginButton.click();
                Thread.sleep(1000);
            } else {
                System.out.println("Login button element is null.");
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}