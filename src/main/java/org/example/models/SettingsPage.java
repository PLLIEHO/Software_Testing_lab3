package org.example.models;

import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SettingsPage extends Page{
    public SettingsPage(WebDriver driver){
        super(driver);
    }

    public void profileSettings(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement profButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[2]/ul/ul/li[2]/a\n"));
        profButton.click();
    }

    public MainPage exit(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement exitButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[2]/ul/div[3]/button\n"));
        exitButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return new MainPage(this.driver);
    }

    public void changeLanguageToEng(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement profButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div[4]/form/fieldset[1]/button\n"));
        profButton.click();
        Util.waitUntilPageLoads(driver, 10);
        WebElement prof1Button = Util.getElementBySelector(driver, By.xpath("//button[@title='English']\n"));
        prof1Button.click();
        Util.waitUntilPageLoads(driver, 10);
        WebElement prof2Button = Util.getElementBySelector(driver, By.xpath("/html/body/div[8]/div/div/div[2]/div/button[2]\n"));
        prof2Button.click();
    }

    public void changeLanguageToRus(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement profButton = Util.getElementBySelector(driver, By.xpath("//button[@class='language-picker']\n"));
        profButton.click();
        Util.waitUntilPageLoads(driver, 10);
        WebElement prof1Button = Util.getElementBySelector(driver, By.xpath("//button[@title='Русский']\n"));
        prof1Button.click();
        Util.waitUntilPageLoads(driver, 10);
        WebElement prof2Button = Util.getElementBySelector(driver, By.xpath("/html/body/div[9]/div/div/div[2]/div/button[2]\n"));
        prof2Button.click();
    }

}
