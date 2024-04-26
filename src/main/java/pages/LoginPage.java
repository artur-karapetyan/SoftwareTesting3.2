package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.LocatorConstants.*;

public class LoginPage extends BasePage {

    private final By notificationLocator = By.xpath("//*[@id=\"__next\"]/div[1]/div/div[1]/div/div[2]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String email, String password) {
        // Input email
        WebElement emailInput = driver.findElement(By.xpath(EMAIL_INPUT_XPATH));
        emailInput.sendKeys(email);

        // Input password
        WebElement passwordInput = driver.findElement(By.xpath(PASSWORD_INPUT_XPATH));
        passwordInput.sendKeys(password);

        // Click submit
        WebElement submitButton = driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator));
    }

    public String getNotificationMessage() {
        WebElement notificationElement = driver.findElement(notificationLocator);
        return notificationElement.getText();
    }
}
