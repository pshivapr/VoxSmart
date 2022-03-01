package com.voxsmart.pageActions;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageActions extends BasePageActions {

    public Map<String, String> cryptos = new HashMap<>();

    @Step("Get Crypto Symbol")
    public String getCryptoSymbol(int row) {
        return getElementText($("(//td//span[@data-qa='watchlist-entity__symbol-cell'])["+row+"]"));
    }

    @Step("Get Change Percentage")
    public String getChangePercentage(int row) {
        return $("(//td/span[@data-qa='watchlist-entity__change-cell'])["+row+"]").getText();
    }

    @Step("click favorite icon")
    public void  clickFavoriteIcon(int row) {
        clickElement($("(//*[@data-qa='star-off-icon']/..)["+row+"]"));
    }

    @Step("table interaction")
    public void interactWithTable(WebDriver driver) {
        $("//td//span[@data-qa='watchlist-entity__symbol-cell']").click();
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    @Step("Add new favorites")
    public void addNewFavorites(WebDriver driver) {

        for(int i=0; i<5; i++) {
            addANewFavorite(driver);
        }
    }

    @Step("Add a new favorite")
    public void addANewFavorite(WebDriver driver) {
        int row = getRandomNumber();

        clickFavoriteIcon(row);
        String symbol = getCryptoSymbol(row);
        String percentage = getChangePercentage(row);
        cryptos.put(symbol, percentage);
    }

    @Step("Confirm favorites added")
    public void assertFavorites(WebDriver driver) {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();

        for(String symbol: cryptos.keySet()){
            assertElementIsVisible(driver, symbol);
        }

        for(String percentageValue: cryptos.values()) {
            assertElementIsVisible(driver, percentageValue);
        }
    }

    @Step("Assert Element is Visible")
    public void assertElementIsVisible(WebDriver driver, String visibleElement) {

        for (int i = 0; i <= 2; i++) {
            try {
                WebElement element = $("//*[text()='" + visibleElement + "']");
                assertThat(element.getText()).isEqualTo(visibleElement);
                break;
            } catch (NoSuchElementException e) {
                new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
            }
        }
    }

}
