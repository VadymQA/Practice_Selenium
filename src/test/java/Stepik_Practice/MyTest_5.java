package Stepik_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest_5 {
    @Test
    public void test5() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        String link = "http://suninjuly.github.io/registration2.html";

        try {
            chromeDriver.get(link);
            chromeDriver.findElement(By.xpath("(//input[@class='form-control first'])[1]")).sendKeys("Ivan");
            chromeDriver.findElement(By.xpath("(//input[@class='form-control second'])[1]")).sendKeys("Petrov");
            chromeDriver.findElement(By.xpath("(//input[@class='form-control third'])[1]")).sendKeys("test@email.com");
            chromeDriver.findElement(By.xpath("(//input[@class='form-control first'])[2]")).sendKeys("123456789012");
            chromeDriver.findElement(By.xpath("(//input[@class='form-control second'])[2]")).sendKeys("Test Address");

            chromeDriver.findElement(By.cssSelector("button.btn")).click();
        } finally {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String assertText = chromeDriver.findElement(By.xpath("//h1")).getText();
            Assert.assertEquals("Congratulations! You have successfully registered!",assertText);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chromeDriver.quit();
        }
    }
}
