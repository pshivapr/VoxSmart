package com.voxsmart.pagesObjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageComponent {

    @FindBy(xpath="//button[@type='button' and contains(@class, 'close-button')]")
    private WebElementFacade closeButton;

    @FindBy(xpath="//span[text()='Skip Tutorial']")
    private WebElementFacade skipTutorialLink;

    @FindBy(xpath="//input[contains(@placeholder, 'First Name')]")
    private WebElementFacade firstName;

    @FindBy(xpath="//td//span[@data-qa='watchlist-entity__symbol-cell']")
    private WebElementFacade tableRow;

    @FindBy(xpath="//div[@data-qa='categories__list' and text()='Favorites']/../..")
    private WebElementFacade favoriteTab;

    @FindBy(xpath="//div[@data-qa='categories__list' and text()='Crypto']/../..")
    private WebElementFacade cryptoTab;

    @Step("Click favorites tab")
    public HomePage clickFavoritesTab() {
        favoriteTab.click();
        return this;
    }

    @Step("Click crypto tab")
    public HomePage clickCryptoTab() {
        cryptoTab.click();
        return this;
    }

    @Step("Click table row")
    public HomePage clickTableRow() {
        tableRow.click();
        return this;
    }

    @Step("Click close button")
    public HomePage clickCloseButton() {
        closeButton.click();
        return this;
    }

    @Step("Click Skip Tutorial")
    public HomePage skipTutorialLink() {
        skipTutorialLink.click();
        return this;
    }

}
