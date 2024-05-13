package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.LocatorConstants.LOGIN_BUTTON_ID;
import static utils.LocatorConstants.SIGN_UP_BUTTON_ID;

public class HomePage extends BasePage {

    private final By loginButtonLocator = By.id(LOGIN_BUTTON_ID);
    private final By signUpButtonLocator = By.id(SIGN_UP_BUTTON_ID);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public void clickSignUpButton() {
        click(signUpButtonLocator);
    }

    public void goToHomePage() {
        driver.get("https://zoomerang.app");
    }

    public boolean isLoginButtonVisible() {

        WebElement loginButton = driver.findElement(loginButtonLocator);
        return loginButton.isDisplayed();
    }

    public boolean isSignUpButtonVisible() {

        WebElement loginButton = driver.findElement(signUpButtonLocator);
        return loginButton.isDisplayed();
    }

}
