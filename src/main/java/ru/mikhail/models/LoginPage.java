package ru.mikhail.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mikhail.Utils;

public class LoginPage extends Page {
    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ProfilePage login(String login, String password) {
        WebElement emailInput = Utils.getElementBySelector(driver, By.xpath("//*[@id='usernameOrEmail']"));
        WebElement authButton = Utils.getElementBySelector(driver, By.xpath("//button[@locale='ru']"));
        emailInput.clear();
        emailInput.sendKeys(login);
        authButton.click();
        WebElement loginPassword = Utils.getElementBySelector(driver, By.xpath("//*[@id='password']"));
        loginPassword.clear();
        loginPassword.sendKeys(password);
        authButton.click();
        Utils.sleep(3000);
        return new ProfilePage(this.driver);
    }
}
