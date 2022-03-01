package com.voxsmart.pagesObjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageComponent {

    @FindBy(xpath="//input[@placeholder='Email']")
    private WebElementFacade inputEmail;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElementFacade inputPassword;

    @FindBy(xpath="//button[@type='submit']")
    private WebElementFacade submitButton;

    @FindBy(xpath="//a[contains(@href, 'avatrade')]//span[text()=' Try free demo ']")
    private WebElementFacade tryFreeDemoButton;

    @Step("Enter email {0}")
    public void emailInput(String email) {
        inputEmail.sendKeys(email);
    }

    @Step("Enter password {0}")
    public void passwordInput(String password) {
        inputPassword.sendKeys(password);
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        submitButton.click();
    }

    @Step("Click Try free demo link")
    public void clickTryFreeDemoLink() {
        tryFreeDemoButton.click();
    }

}
