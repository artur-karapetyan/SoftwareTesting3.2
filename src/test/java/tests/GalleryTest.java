package tests;

import org.testng.annotations.Test;
import pages.GalleryPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.AssertionMessages.*;

public class GalleryTest extends BaseTest {

    @Test
    public void testGallerySearch() {
        HomePage homePage = new HomePage(driver);
        GalleryPage galleryPage = new GalleryPage(driver);
        homePage.goToGalleryPage();

        galleryPage.searchArt("car");

        assertTrue(galleryPage.isTitleCorrect("Car AI Generated Art"), GALLERY_TITLE_IS_FALSE);
    }

    @Test
    public void testGalleryFilters() {
        HomePage homePage = new HomePage(driver);
        GalleryPage galleryPage = new GalleryPage(driver);
        homePage.goToGalleryPage();

        galleryPage.selectFilters();

        assertEquals(galleryPage.getFirstTwoItemsStyles(), GALLERY_STYLE_TO_COMPARE);
    }
}
