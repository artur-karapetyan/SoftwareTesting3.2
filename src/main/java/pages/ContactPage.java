package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.LocatorConstants.*;

public class ContactPage extends BasePage {

    private final By fullNameLocator = By.xpath(CONTACT_FULL_NAME);
    private final By phoneLocator = By.xpath(CONTACT_PHONE);
    private final By emailLocator = By.xpath(CONTACT_EMAIL);
    private final By textLocator = By.xpath(CONTACT_TEXT);

    private final By emailErrorLocator = By.xpath(EMAIL_ERROR_XPATH);
    private final By nameErrorLocator = By.xpath(FULL_NAME_EMPTY_XPATH);

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void writeFullName(String text) {
        WebElement nameInput = driver.findElement(fullNameLocator);
        nameInput.sendKeys(text);
    }

    public void focusFullNameInput() {
        WebElement nameInput = driver.findElement(fullNameLocator);
        nameInput.click();
    }

    public void writePhone(String text) {
        WebElement phoneInput = driver.findElement(phoneLocator);
        phoneInput.sendKeys(text);
    }

    public void writeEmail(String text) {
        WebElement emailInput = driver.findElement(emailLocator);
        emailInput.sendKeys(text);
    }

    public void writeText(String text) {
        WebElement textInput = driver.findElement(textLocator);
        textInput.sendKeys(text);
    }

    public String getNameError() {
        WebElement nameError = driver.findElement(nameErrorLocator);
        return nameError.getText();
    }

    public String getEmailError() {
        WebElement emailError = driver.findElement(emailErrorLocator);
        return emailError.getText();
    }

}
