package org.example.models;


import lombok.SneakyThrows;
import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        Util.waitUntilPageLoads(driver, 10);
        var loginButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/nav/ul[2]/li[1]/a\n"));
        loginButton.click();

        return new LoginPage(this.driver);
    }

    public FeaturesPage goToFeaturesPage() {
        Util.waitUntilPageLoads(driver, 10);
        var hover = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/nav/ul[1]/li[3]/button\n"));
        var button = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[1]/div[5]/ul/li[1]/a\n"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.moveToElement(button).build().perform();
        button.click();

        return new FeaturesPage(this.driver);
    }

}
