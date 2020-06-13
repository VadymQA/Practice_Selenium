package com.IT.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class ProductPage extends BasePage{

    @FindBy(css=".btn.btn-lg.btn-primary.btn-add-to-basket")
    private WebElement btnAddToCart;
	@FindBy(css="p.price_color")
	private WebElement price;
	@FindBy(css=".col-sm-6.product_main > h1")
	private WebElement name;


   String page_url = "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=newYear2019";


    public void navigateToProductPage() {
        driver.get(page_url);
    }

    public String getItemName () {
        String itenName = name.getText();
        return itenName;
    }

    public String getItemPrice() {
       String itemPrice =  price.getText();
        return itemPrice;
    }

    public void addToCart () {
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnAddToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert =  driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        String[] splited = alertText.split(" ");
        System.out.println("x is" + Arrays.toString(splited) );
        int x = Integer.parseInt(splited[2]);
        System.out.println(x);
        double y = Math.log(Math.abs(12*Math.sin(x)));
        alert.sendKeys(y+"");
        alert.accept();
            Alert alert2 =  driver.switchTo().alert();
            String alertText2 = alert.getText();
            System.out.println(alertText2);
            alert2.accept();
    }



}
