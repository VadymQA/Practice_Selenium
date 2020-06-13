package Stepik_Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyTest_7_getAtt {
    @Test
    public void test7() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);
        String link = "http://suninjuly.github.io/get_attribute.html";

        try {
            chromeDriver.get(link);
            chromeDriver.manage().window().maximize();

            int x = Integer.parseInt(chromeDriver.findElement(By.cssSelector("#treasure")).getAttribute("valuex"));
            double y = Math.log(Math.abs(12*Math.sin(x)));
            String answer = Double.toString(y);

            chromeDriver.findElement(By.cssSelector("#answer")).sendKeys(answer);
            chromeDriver.findElement(By.cssSelector("#robotCheckbox")).click();
            chromeDriver.findElement(By.cssSelector("#robotsRule")).click();
            chromeDriver.findElement(By.xpath("//button[@type='submit']")).click();

        } finally {

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = chromeDriver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println(alertText);
            chromeDriver.quit();
        }
    }
}
