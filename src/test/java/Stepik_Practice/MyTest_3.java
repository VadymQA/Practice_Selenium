package Stepik_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class MyTest_3 {
    @Test
    public void testName() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        String link = "http://suninjuly.github.io/huge_form.html";

        try {
            chromeDriver.get(link);

            List<WebElement> elements = chromeDriver.findElements(By.xpath("//input[@type='text']"));
            for (int i = 0; i < elements.size(); i++) {
                elements.get(i).sendKeys("Test");
            }
            chromeDriver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        } finally {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chromeDriver.quit();

        }
    }
}
