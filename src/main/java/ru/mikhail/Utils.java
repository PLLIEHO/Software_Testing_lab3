package ru.mikhail;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static WebElement getElementBySelector(WebDriver driver, By selector) {
        var driverWait = new WebDriverWait(driver, Duration.ofSeconds(5L), Duration.ofMillis(100L));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    @SneakyThrows
    public static void sleep(long millis) {
        Thread.sleep(millis);
    }
}
