package pages;

import listeners.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.LocatorConstants.LOGIN_BUTTON_ID;

public class HomePage extends BasePage {

    private final By loginButtonLocator = By.id(LOGIN_BUTTON_ID);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public void goToHomePage() {
        driver.get("https://zoomerang.app");
    }

    public boolean isLoginButtonVisible() {

        try {
            WebElement loginButton = driver.findElement(loginButtonLocator);
            return loginButton.isDisplayed();
        } catch (NoSuchElementException e) {
            ScreenshotListener screenshotListener = new ScreenshotListener(driver);
            screenshotListener.takeScreenshot("login_Button_Not_Found");
            return false;
        }
    }

}
