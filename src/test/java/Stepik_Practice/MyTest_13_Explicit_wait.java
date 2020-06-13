package Stepik_Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyTest_13_Explicit_wait {
    @Test
    public void test13() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

        String link = "http://suninjuly.github.io/explicit_wait2.html";

        try {
            chromeDriver.get(link);
            chromeDriver.manage().window().maximize();
            String main_page = chromeDriver.getWindowHandle();

            WebElement price_text = chromeDriver.findElement(By.id("price"));
            wait.until(ExpectedConditions.textToBePresentInElement(price_text, "$100"));
            chromeDriver.findElement(By.id("book")).click();

            WebElement input_value = chromeDriver.findElement(By.id("input_value"));

            wait.until(ExpectedConditions.visibilityOf(input_value));
            int x = Integer.parseInt(input_value.getText());
            double y = Math.log(Math.abs(12 * Math.sin(x)));
            String answer = Double.toString(y);

            chromeDriver.findElement(By.xpath("//*[@class='form-control']")).sendKeys(answer);
            chromeDriver.findElement(By.xpath("//*[@type='submit']")).click();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = chromeDriver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            alert.accept();

        } finally {
            chromeDriver.quit();
        }
    }
}
