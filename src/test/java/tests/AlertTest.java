package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void simpleAlertTest() {
        browsersService.getDriver().get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement button = browsersService.getDriver().findElement(By.xpath("//button[. = 'Click for JS Alert']"));
        button.click();

        Alert alert = browsersService.getDriver().switchTo().alert();
        System.out.println(alert.getText());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        alert.accept();
    }
}
