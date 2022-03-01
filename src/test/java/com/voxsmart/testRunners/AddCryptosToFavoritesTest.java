//package com.voxsmart.testRunners;
//
//import com.voxsmart.pageActions.HomePageActions;
//import com.voxsmart.pagesObjects.LandingPage;
//import com.voxsmart.pageActions.NavigateActions;
//import com.voxsmart.pageActions.OpenDemoAccountPageActions;
//import com.voxsmart.pagesObjects.HomePage;
//import net.serenitybdd.junit5.SerenityJUnit5Extension;
//import net.thucydides.core.annotations.Managed;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.openqa.selenium.WebDriver;
//
//@ExtendWith(SerenityJUnit5Extension.class)
//class AddCryptosToFavoritesTest {
//
//    /**
//     * Define the webdriver instance to be used for these tests, for running headless add options = "headless" to the annotation
//     */
//    @Managed(driver = "chrome")
//    WebDriver driver;
//
//    /**
//     * Navigation actions. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
//     */
//    NavigateActions navigate;
//
//    /**
//     * Page Objects and Actions related to pages. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
//     */
//    HomePage homePage;
//    LandingPage landingPage;
//    OpenDemoAccountPageActions openDemoAccountPageActions;
//    HomePageActions homePageActions;
//
//    @Test
//    void AddCryptosToFavorites() {
//        navigate.toTheHomePage(driver);
//        landingPage.clickTryFreeDemoLink();
//        openDemoAccountPageActions.createDemoAccount(driver);
//
//        homePage.clickCloseButton().skipTutorialLink().clickCryptoTab();
//        homePageActions.interactWithTable(driver);
//        homePageActions.addNewFavorites(driver);
//
//        homePage.clickFavoritesTab();
//        homePageActions.interactWithTable(driver);
//        homePageActions.assertFavorites(driver);
//    }
//}
