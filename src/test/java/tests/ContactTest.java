package tests;

import org.testng.annotations.Test;
import pages.ContactPage;
import pages.GalleryPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.AssertionMessages.*;

public class ContactTest extends BaseTest {

    @Test
    public void testEmailWithoutAt() {
        HomePage homePage = new HomePage(driver);
        ContactPage contactPage = new ContactPage(driver);
        homePage.goToHomePage();
        homePage.clickContactButton();

        contactPage.writeFullName("testing");
        contactPage.writeEmail("test");
        contactPage.writeText("testing");

        assertEquals(contactPage.getEmailError(), CONTACT_SHOULD_CONTAIN_AT);
    }

    @Test
    public void testEmailExtension() {
        HomePage homePage = new HomePage(driver);
        ContactPage contactPage = new ContactPage(driver);
        homePage.goToHomePage();
        homePage.clickContactButton();

        contactPage.writeFullName("testing");
        contactPage.writeEmail("test@test");
        contactPage.writeText("testing");

        assertEquals(contactPage.getEmailError(), CONTACT_WRONG_EXTENSION);
    }

    @Test
    public void testNameEmpty() {
        HomePage homePage = new HomePage(driver);
        ContactPage contactPage = new ContactPage(driver);
        homePage.goToHomePage();
        homePage.clickContactButton();

        contactPage.focusFullNameInput();
        contactPage.writeEmail("test@test");

        assertEquals(contactPage.getNameError(), CONTACT_CANNOT_BE_EMPTY);
    }
}