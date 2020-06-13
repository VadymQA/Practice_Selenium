package Stepik_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyTest {
    @Test
    public void testName() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        String link = "http://suninjuly.github.io/simple_form_find_task.html";


        try {
            chromeDriver.get(link);
            chromeDriver.findElement(By.name("first_name")).sendKeys("Ivan");
            chromeDriver.findElement(By.name("last_name")).sendKeys("Petrov");
            chromeDriver.findElement(By.cssSelector(".form-control.city")).sendKeys("Kharkiv");
            chromeDriver.findElement(By.id("country")).sendKeys("Ukraine");
            chromeDriver.findElement(By.id("submit_button")).click();
        } finally {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chromeDriver.quit();
        }

    }
}
