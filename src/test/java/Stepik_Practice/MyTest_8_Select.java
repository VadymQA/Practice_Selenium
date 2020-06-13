package Stepik_Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyTest_8_Select {
    @Test
    public void test8() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

        String[] links = {"http://suninjuly.github.io/selects1.html", "http://suninjuly.github.io/selects2.html"};

        for (int i = 0; i < links.length; i++) {
            try {
                chromeDriver.get(links[i]);
                chromeDriver.manage().window().maximize();
                int x1 = Integer.parseInt(chromeDriver.findElement(By.id("num1")).getText());
                int x2 = Integer.parseInt(chromeDriver.findElement(By.id("num2")).getText());
                String answer = Integer.toString(x1 + x2);
                WebElement dropdown = chromeDriver.findElement(By.id("dropdown"));
                Select select = new Select(dropdown);
                select.selectByValue(answer);

                chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = chromeDriver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println(alertText);
                alert.accept();
            } finally {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        chromeDriver.quit();
    }
}
