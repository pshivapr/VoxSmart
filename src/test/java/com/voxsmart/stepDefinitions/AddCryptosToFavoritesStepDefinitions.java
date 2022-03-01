package com.voxsmart.stepDefinitions;

import com.voxsmart.pageActions.HomePageActions;
import com.voxsmart.pageActions.NavigateActions;
import com.voxsmart.pageActions.OpenDemoAccountPageActions;
import com.voxsmart.pagesObjects.HomePage;
import com.voxsmart.pagesObjects.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AddCryptosToFavoritesStepDefinitions {

    /**
     * Define the webdriver instance to be used for these tests, for running headless add options = "headless" to the annotation
     */
    @Managed(driver = "chrome")
    WebDriver driver;

    /**
     * Navigation actions. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
     */
    NavigateActions navigate;

    /**
     * Page Objects and Actions related to pages. This is a UIInteraction class, so it will be instantiated automatically by Serenity.
     */
    HomePage homePage;
    LandingPage landingPage;
    OpenDemoAccountPageActions openDemoAccountPageActions;
    HomePageActions homePageActions;

    @Given("a demo user account is created")
    public void a_demo_user_account_is_created() {
        navigate.toTheHomePage(driver);
        landingPage.clickTryFreeDemoLink();
        openDemoAccountPageActions.createDemoAccount(driver);
    }

    @When("I add random cryptos as favorites")
    public void i_add_random_cryptos_as_favorites() {
        homePage.clickCloseButton().skipTutorialLink().clickCryptoTab();
        homePageActions.interactWithTable(driver);
        homePageActions.addNewFavorites(driver);
    }

    @And("I click on favorite tab and view the page")
    public void i_click_on_favorite_tab_and_view_the_page() {
        homePage.clickFavoritesTab();
    }

    @Then("the cryptos are added and can be seen")
    public void the_cryptos_are_added_and_can_be_seen() {
        homePageActions.interactWithTable(driver);
        homePageActions.assertFavorites(driver);
    }

}
