package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;

public class BaseTest {

    protected WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (!result.isSuccess()) {
            try {

                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                File screenshotsDir = new File("screenshots");
                if (!screenshotsDir.exists()) {
                    screenshotsDir.mkdirs();
                }

                File destFile = new File(screenshotsDir, result.getMethod().getMethodName() + "_failure.png");

                Files.copy(scrFile.toPath(), destFile.toPath());
                System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
