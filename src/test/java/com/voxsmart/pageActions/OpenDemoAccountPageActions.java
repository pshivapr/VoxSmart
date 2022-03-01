package com.voxsmart.pageActions;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;

public class OpenDemoAccountPageActions extends BasePageActions {

    @Step("Enter First Name {0}")
    public void enterFirstName(String firstName) { $("//input[contains(@placeholder, 'First Name')]").sendKeys(firstName);}

    @Step("Enter Last Name {0}")
    public void enterLastName(String lastName) {
        $("//input[contains(@placeholder, 'Last Name')]").sendKeys(lastName);
    }

    @Step("Enter Email {0}")
    public void enterEmail(String email) {
        $("//input[contains(@placeholder, 'Email')]").sendKeys(email);
    }

    @Step("Enter Phone Number {0}")
    public void enterPhoneNumber(String phone) {
        WebElement element = $("//input[@id='phoneInput']");
        element.sendKeys(phone);
        element.sendKeys(Keys.TAB);
    }

    @Step("Select GDPR policy")
    public void selectGDPRCheckbox(WebDriver driver) {
        WebElement element = $("#GDPR");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Step("Click Create Account button")
    public void clickCreateAccountButton() {
        WebElement element = $("#avaWidgetSubmit.btn.btn-green");
        try {
            withAction().moveToElement(element).build().perform();
            element.sendKeys(Keys.ENTER);
        } catch(ElementNotInteractableException e) {
            element.sendKeys(Keys.TAB);
            element.sendKeys(Keys.ENTER);
        }
    }

    @Step("Create Demo Account")
    public void createDemoAccount(WebDriver driver) {

        String firstName = generateRandomString(3, "abcdefghijklmnopqrstuvwxyz");
        String lastName = generateRandomString(5, "abcdefghijklmnopqrstuvwxyz");
        String phone = generateRandomString(10, "123456789");

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(firstName + "." + lastName + "@test.com");
        enterPhoneNumber(phone);
        selectGDPRCheckbox(driver);
        clickCreateAccountButton();
    }

}
