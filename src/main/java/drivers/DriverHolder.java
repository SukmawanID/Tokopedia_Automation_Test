package drivers;

import org.openqa.selenium.WebDriver;

public class DriverHolder {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void setDriver(WebDriver driver) {
        DriverHolder.driver.set(driver);
    }
}
