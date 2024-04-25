package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;
import static utils.AssertionMessages.LOGIN_BUTTON_NOT_FOUND;

public class Test1 extends BaseTest {

    @Test
    public void testLoginButtonExists() {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        assertTrue(homePage.isLoginButtonVisible(), LOGIN_BUTTON_NOT_FOUND);
    }
}
