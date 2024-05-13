package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.LocatorConstants.*;

public class HomePage extends BasePage {

    private final By loginButtonLocator = By.id(LOGIN_BUTTON_ID);
    private final By signUpButtonLocator = By.id(SIGN_UP_BUTTON_ID);

    private final By contactButtonLocator = By.xpath(CONTACT_BUTTON);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clickContactButton() {
        scrollToBottom();

        WebElement contactButton = driver.findElement(contactButtonLocator);

        contactButton.click();
    }

    public void clickSignUpButton() {
        click(signUpButtonLocator);
    }

    public void goToGalleryPage() {
        driver.get("https://zoomerang.app/ai-gallery");
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
