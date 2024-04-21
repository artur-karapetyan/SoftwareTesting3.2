package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.AssertionMessages;

import static org.testng.Assert.assertTrue;

public class Test1 extends BaseTest {

    @Test
    public void testLoginButtonExists() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        assertTrue(homePage.isLoginButtonVisible(), AssertionMessages.LOGIN_BUTTON_NOT_FOUND);
    }
}
