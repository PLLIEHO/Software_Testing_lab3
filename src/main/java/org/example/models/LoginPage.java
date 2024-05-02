package org.example.models;

import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage login(String login, String password) {
        Util.waitUntilPageLoads(driver, 10);
        WebElement emailInput = Util.getElementBySelector(driver, By.xpath("//*[@id='usernameOrEmail']\n"));
        WebElement authButton = Util.getElementBySelector(driver, By.xpath("//button[@locale='ru']\n"));
        emailInput.clear();
        emailInput.sendKeys(login);
        authButton.click();
        Util.waitUntilPageLoads(driver, 10);
        WebElement loginPassword = Util.getElementBySelector(driver, By.xpath("//*[@id='password']\n"));
        loginPassword.clear();
        loginPassword.sendKeys(password);
        authButton.click();
        try {
            Thread.sleep(5000);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
            return new ProfilePage(this.driver);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
