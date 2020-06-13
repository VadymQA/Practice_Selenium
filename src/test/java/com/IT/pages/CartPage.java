package com.IT.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

	@FindBy(css=".col-sm-4>h3>a")
	private WebElement name;
	@FindBy(css=".col-sm-1>p")
	private WebElement price;





    public void navigateToCartPage () {
        driver.get("http://selenium1py.pythonanywhere.com/ru/basket/");
    }

    public String getNameItemsinCart () {

        String itenName = name.getText();
        return itenName;
    }

    public String getPriceItemsinCart() {
        String itemPrice =  price.getText();
        return itemPrice;
    }
}
