package com.IT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static WebDriver driver;
        static {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://selenium1py.pythonanywhere.com/catalogue/the-shellcoders-handbook_209/?promo=newYear");
        driver.manage().window().maximize();
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    /*public boolean isPresented(WebElement webElement) {
        try {
            webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element is not presented");
            return false;
        }
        return true;
    }*/
}
