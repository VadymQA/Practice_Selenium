package Stepik_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyTest_6 {
    @Test
    public void test6() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        String link = "http://suninjuly.github.io/math.html?ruler=robots";

        try {
            chromeDriver.get(link);
            chromeDriver.manage().window().maximize();

            int x = Integer.parseInt(chromeDriver.findElement(By.cssSelector("#input_value")).getText());
            double y = Math.log(Math.abs(12*Math.sin(x)));
            String answer = Double.toString(y);
            chromeDriver.findElement(By.cssSelector("#answer")).sendKeys(answer);
            chromeDriver.findElement(By.cssSelector("#robotCheckbox")).click();
            chromeDriver.findElement(By.cssSelector("#robotsRule")).click();
            chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

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
