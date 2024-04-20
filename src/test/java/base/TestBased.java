package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import drivers.DriverFactory;
import utilities.url;
import pages.WaitPages;
import pages.HomePages;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.IOException;
import static drivers.DriverHolder.setDriver;
public class TestBased {

    public WebDriver driver;

    public static Properties properties;
    public static FileInputStream readProperty;
    public static String project_name;

    public static void setProjectDetails() throws IOException {
        // TODO: Step1 :declare object of properties file
        readProperty = new FileInputStream( System.getProperty("user.dir") + "/src/test/java/properties/environment.properties");
        properties = new Properties();
        properties.load(readProperty);

        //TODO: Step2 : define name from properties file
        project_name = properties.getProperty("projectName");

    }

    @Parameters("browser")
    @BeforeMethod
    public void setupDriver() throws InterruptedException {
        String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : properties.getProperty("browser");
        driver = DriverFactory.getNewInstance(browser);
        setDriver(driver);
        driver.get(url.tokopedia_homepage_url);
        //driver.get(url.orange_hrm_url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


    public String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File source = screenShot.getScreenshotAs(OutputType.FILE);
        Date currentDate=new Date();
        String screenshotName=currentDate.toString().replace(" ","-").replace(":","-");
        File fileScreenShot = new File(System.getProperty("user.dir") + "/src/test/resources/Screenshots/"+ screenshotName + "-" + testCaseName + ".png");
        FileUtils.copyFile(source, fileScreenShot);
        return System.getProperty("user.dir") + "/src/test/resources/Screenshots/"+ screenshotName + "-" + testCaseName + ".png";
    }

}