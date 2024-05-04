package ru.mikhail.models;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mikhail.Utils;

public class MainPage extends Page {
    public MainPage(RemoteWebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        var loginButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/nav/ul[2]/li[1]/a"));
        loginButton.click();

        return new LoginPage(this.driver);
    }

    public FeaturesPage goToFeaturesPage() {
        var hover = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/nav/ul[1]/li[3]/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover).build().perform();
        Utils.sleep(1000);
        var button = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[1]/div[5]/ul/li[1]/a"));
        actions.moveToElement(button).build().perform();
        button.click();

        return new FeaturesPage(driver);
    }

    public void goToSupportPage() {
        var hover = Utils.getElementBySelector(driver, By.xpath("//button[@data-dropdown-trigger='resources']"));
        var actions = new Actions(driver);
        actions.moveToElement(hover).build().perform();
        Utils.sleep(1000);
        var button = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[1]/div[6]/ul/li[1]/a"));
        actions.moveToElement(button).build().perform();
        button.click();
    }
}
