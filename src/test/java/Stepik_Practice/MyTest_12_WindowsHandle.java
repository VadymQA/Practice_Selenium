package Stepik_Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;

public class MyTest_12_WindowsHandle {
    @Test
    public void test12() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

        String link = "http://suninjuly.github.io/redirect_accept.html";

        try {
            chromeDriver.get(link);
            chromeDriver.manage().window().maximize();
            String main_page = chromeDriver.getWindowHandle();

            chromeDriver.findElement(By.xpath("//*[@type='submit']")).click();

            Set<String> handles = chromeDriver.getWindowHandles();
            for (String handle : handles) {
                chromeDriver.switchTo().window(handle);
            }
            String second_page = chromeDriver.getWindowHandle();
            chromeDriver.switchTo().window(second_page);

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
