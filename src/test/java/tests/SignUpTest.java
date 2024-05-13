package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.AssertionMessages.*;

public class SignUpTest extends BaseTest {

    @Test
    public void testLoginButtonExists() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        assertTrue(homePage.isLoginButtonVisible(), LOGIN_BUTTON_NOT_FOUND);
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        testLoginButtonExists();

        homePage.clickLoginButton();

        loginPage.login("test@example.com", "incorrectpassword");

        String notificationMessage = loginPage.getNotificationMessage();
        assertEquals(notificationMessage, USER_NOT_FOUND);

        homePage.goToHomePage();
    }

    @Test
    public void testSignUpButtonExists() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        assertTrue(homePage.isSignUpButtonVisible(), SIGN_UP_BUTTON_NOT_FOUND);
    }

    @Test
    public void testSignUpWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        testSignUpButtonExists();

        homePage.clickSignUpButton();

        loginPage.signUp("test@example.com", "incorrectpassword", "incorrectpassword");

        String notificationMessage = loginPage.getNotificationMessage();
        assertEquals(notificationMessage, EMAIL_NOT_VALID);
    }

    @Test
    public void testSignUpWithInvalidConfirmPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        testSignUpButtonExists();

        homePage.clickSignUpButton();

        loginPage.fillSignUpFields("test@example.com", "incorrectpassword", "incorrectPassword");

        assertTrue(loginPage.isSignUpButtonDisabled(), SIGN_UP_BUTTON_ENABLED);
    }
}
