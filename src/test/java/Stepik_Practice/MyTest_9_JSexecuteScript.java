package Stepik_Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyTest_9_JSexecuteScript {
    @Test
    public void test9() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

        String link = "http://suninjuly.github.io/execute_script.html";

        try {
            chromeDriver.get(link);
            chromeDriver.manage().window().maximize();
            int x = Integer.parseInt(chromeDriver.findElement(By.id("input_value")).getText());

            double y = Math.log(Math.abs(12 * Math.sin(x)));
            String answer = Double.toString(y);

            chromeDriver.findElement(By.cssSelector("#answer")).sendKeys(answer);
            WebElement btn_submit = chromeDriver.findElement(By.xpath("//button[@type='submit']"));
            chromeDriver.executeScript("return arguments[0].scrollIntoView(true);", btn_submit);
            //chromeDriver.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            chromeDriver.findElement(By.cssSelector("#robotCheckbox")).click();
            chromeDriver.findElement(By.cssSelector("#robotsRule")).click();

            btn_submit.click();

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

        chromeDriver.quit();
    }
}
