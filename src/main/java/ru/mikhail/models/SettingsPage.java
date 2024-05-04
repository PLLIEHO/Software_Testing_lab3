package ru.mikhail.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mikhail.Utils;

import java.util.ArrayList;
import java.util.List;

public class SettingsPage extends Page {
    public SettingsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void profileSettings() {
        WebElement profButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[2]/ul/ul/li[2]/a"));
        profButton.click();
    }

    public void exit() {
        WebElement exitButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[2]/ul/div[3]/button"));
        exitButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void changeLanguageToEng() {
        WebElement profButton = Utils.getElementBySelector(driver, By.xpath("//button[@class='language-picker']"));
        profButton.click();
        WebElement prof1Button = Utils.getElementBySelector(driver, By.xpath("//button[@title='English']"));
        prof1Button.click();
        WebElement prof2Button = Utils.getElementBySelector(driver, By.xpath("//button[@class='components-button is-secondary']"));
        prof2Button.click();
    }

    public void changeLanguageToRus() {
        WebElement profButton = Utils.getElementBySelector(driver, By.xpath("//button[@class='language-picker']"));
        profButton.click();
        WebElement prof1Button = Utils.getElementBySelector(driver, By.xpath("//button[@title='Русский']"));
        prof1Button.click();
        WebElement prof2Button = Utils.getElementBySelector(driver, By.xpath("//button[@class='components-button is-secondary']"));
        prof2Button.click();
    }
}
