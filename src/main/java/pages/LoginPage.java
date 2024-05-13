package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.LocatorConstants.*;

public class LoginPage extends BasePage {

    private final By notificationLocator = By.xpath(NOTIFICATION_XPATH);


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

    public void signUp(String email, String password, String confirm) {
        fillSignUpFields(email, password, confirm);

        // Click submit
        WebElement submitButton = driver.findElement(By.xpath(SING_UP_SUBMIT_BUTTON_XPATH));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator));
    }

    public void fillSignUpFields(String email, String password, String confirm) {
        // Input email
        WebElement emailInput = driver.findElement(By.xpath(SIGN_UP_EMAIL_INPUT_XPATH));
        emailInput.sendKeys(email);

        // Input password
        WebElement passwordInput = driver.findElement(By.xpath(SIGN_UP_PASSWORD_INPUT_XPATH));
        passwordInput.sendKeys(password);

        // Input confirm password
        WebElement confirmPassword = driver.findElement(By.xpath(SING_UP_CONFIRM_INPUT_XPATH));
        confirmPassword.sendKeys(confirm);
    }

    public String getNotificationMessage() {
        WebElement notificationElement = driver.findElement(notificationLocator);
        return notificationElement.getText();
    }

    public boolean isSignUpButtonDisabled() {
        WebElement submitButton = driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
        return !submitButton.isEnabled();
    }
}
