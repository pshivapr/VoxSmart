package com.voxsmart.pageActions;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class BasePageActions  extends UIInteractions {

    @Step("Move to element and click")
    public void clickElement(WebElement element) {

        for (int i = 0; i <= 2; i++) {
            try {
                withAction().moveToElement(element).build().perform();
                element.click();
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException | NoSuchElementException e) {
                e.getMessage();
            }
        }
    }

    @Step("Get element text")
    public String getElementText(WebElement element) {
        withAction().moveToElement(element).build().perform();
        return element.getText();
    }

    @Step("Get random number")
    public int getRandomNumber() {
        Random rand = new Random();
        int upperbound = 5;
        int row = rand.nextInt(upperbound);
        if(row==0)
            row++;
        return row;
    }

    @Step("Generate Random String of length {0} with {0}")
    public String generateRandomString(int length, String chars) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i=0; i< length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
