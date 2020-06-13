package Stepik_Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyTest_10_Upload {
    @Test
    public void test10() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

        String link = "http://suninjuly.github.io/file_input.html";

        try {
            chromeDriver.get(link);
            chromeDriver.manage().window().maximize();

            chromeDriver.findElement(By.name("firstname")).sendKeys("Vasya");
            chromeDriver.findElement(By.name("lastname")).sendKeys("Ivanov");
            chromeDriver.findElement(By.name("email")).sendKeys("email@mail.com");

            WebElement upload_btn = chromeDriver.findElement(By.id("file"));
            upload_btn.sendKeys("C:\\Users\\Vadim\\Desktop\\test.txt");

            chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

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
