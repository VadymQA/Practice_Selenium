package com.IT.tests;

import com.IT.pages.CartPage;
import com.IT.pages.MainPage;
import com.IT.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
    @Test
    public void openLoginPage() {
        MainPage mainPage = new MainPage();
        mainPage.shouldBeLoginLink();
        mainPage.goToLoginPage();
    }

    @Test
    public void additemToCart() {
        ProductPage productPage = new ProductPage();
        productPage.navigateToProductPage();
        String itemName = productPage.getItemName();
        String itemPrice = productPage.getItemPrice();
        productPage.addToCart();
        CartPage cart = new CartPage();
        cart.navigateToCartPage();
        Assert.assertEquals(itemName, cart.getNameItemsinCart());
        Assert.assertEquals(itemPrice, cart.getPriceItemsinCart());
    }


}
