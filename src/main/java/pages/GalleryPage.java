package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static utils.LocatorConstants.*;

public class GalleryPage extends BasePage {

    private final By inputLocator = By.id(GALLERY_INPUT_ID);
    private final By titleLocator = By.xpath(GALLERY_TITLE_XPATH);

    private final By filterLocator = By.xpath(GALLERY_FILTER_DROPDOWN_BUTTON);

    private final By textToVideoLocator = By.xpath(GALLERY_FILTER_TOOL_XPATH);

    private final By styleLocator = By.xpath(GALLERY_FILTER_STYLE_XPATH);

    private final By applyButtonLocator = By.xpath(GALLERY_FILTER_APPLY_BUTTON);

    private final By firstItemLocator = By.xpath(GALLERY_FIRST_ITEM_STYLE);
    private final By secondItemLocator = By.xpath(GALLERY_SECOND_ITEM_STYLE);

    public GalleryPage(WebDriver driver) {
        super(driver);
    }


    public void searchArt(String text) {
        WebElement artInput = driver.findElement(inputLocator);
        artInput.sendKeys(text);
        artInput.sendKeys(Keys.ENTER);
    }

    public boolean isTitleCorrect(String title) {
        WebElement titleElement = driver.findElement(titleLocator);
        String pageTitle = titleElement.getText();

        return Objects.equals(pageTitle, title);
    }

    public void selectFilters() {
        // Open DropDown
        WebElement filterDropdown = driver.findElement(filterLocator);
        filterDropdown.click();

        // Select Text To Video Tool
        WebElement toolButton = driver.findElement(textToVideoLocator);
        toolButton.click();

        // Select Photoreal style
        WebElement styleButton = driver.findElement(styleLocator);
        styleButton.click();

        // Apply Filters
        WebElement applyButton = driver.findElement(applyButtonLocator);
        applyButton.click();
    }

    public String getFirstTwoItemsStyles() {

        // Hover first element
        WebElement firstElement = driver.findElement(By.xpath(GALLERY_FIRST_ELEMENT_HOVER));
        Actions firstAction = new Actions(driver);
        firstAction.moveToElement(firstElement).perform();

        // Get first item text
        WebElement firstItem = driver.findElement(firstItemLocator);
        String firstStyle = firstItem.getText();

        // Hover second element
        WebElement secondElement = driver.findElement(By.xpath(GALLERY_SECOND_ELEMENT_HOVER));
        Actions secondAction = new Actions(driver);
        secondAction.moveToElement(secondElement).perform();

        // Get second item text
        WebElement secondItem = driver.findElement(secondItemLocator);
        String secondStyle = secondItem.getText();

        return Objects.equals(firstStyle, secondStyle) ? firstStyle : "wrong_style";
    }
}
