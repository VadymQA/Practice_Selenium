package com.IT.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends BasePage {

    @FindBy(css = "#login_link")
    private WebElement linkLogin;

    @FindBy(css = "#login_link_invalid")
    private WebElement linkLoginInvalid;

    public void goToLoginPage() {
        linkLogin.click();
    }

    public void shouldBeLoginLink() {
        try { Assert.assertEquals(true, linkLogin.isDisplayed()); }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }


}
