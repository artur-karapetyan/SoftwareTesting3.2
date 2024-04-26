package tests;

import listeners.ScreenshotListener;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.AssertionMessages.LOGIN_BUTTON_NOT_FOUND;
import static utils.AssertionMessages.USER_NOT_FOUND;

public class Test1 extends BaseTest {

    @Test
    public void testLoginButtonExists() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        assertTrue(homePage.isLoginButtonVisible(), LOGIN_BUTTON_NOT_FOUND);
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver) ;

        testLoginButtonExists();

        homePage.clickLoginButton();

        loginPage.login("test@example.com", "incorrectpassword");

        String notificationMessage = loginPage.getNotificationMessage();
        ScreenshotListener screenshotListener = new ScreenshotListener(driver);
        screenshotListener.takeScreenshot("user_not_found_notification");
        assertEquals(notificationMessage, USER_NOT_FOUND);

        homePage.goToHomePage();
    }
}
