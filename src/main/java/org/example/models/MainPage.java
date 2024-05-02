package org.example.models;


import lombok.SneakyThrows;
import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        var loginButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/nav/ul[2]/li[1]/a\n"));
        loginButton.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return new LoginPage(this.driver);
    }

//    public AdsPage goToAdsPage() {
//        var adsButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div[5]/a\n"));
//        adsButton.click();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        Util.waitUntilPageLoads(driver, 10);
//        return new AdsPage(this.driver);
//    }
//
//    public Page goToLadyPage() {
//        var ladyButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div[3]/a\n"));
//        ladyButton.click();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        Util.waitUntilPageLoads(driver, 10);
//        return new Page(this.driver);
//    }
//
//    public Page goToFinancePage() {
//        var financeButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div/div[4]/a\n"));
//        financeButton.click();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        Util.waitUntilPageLoads(driver, 10);
//        return new Page(this.driver);
//    }
//
//    public Page openFirstNews() {
//        var firstNews = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[1]/div[1]/a[2]\n"));
//        firstNews.click();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabs.size() - 1));
//        return new Page(this.driver);
//    }
//
//    public Page openFirstNewsFromSearch() {
//        var firstNews = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[4]/div[2]/div[2]/a[2]/div"));
//        firstNews.click();
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabs.size() - 1));
//        return new Page(this.driver);
//    }
//
//    public MainPage switchToPoliticTheme() {
//        var politicTab = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[1]/nav/div[1]/div/div[1]/div[3]/a\n"));
//        politicTab.click();
//
//        return new MainPage(this.driver);
//    }
//
//    public void sortNews() {
//        var newsImg = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[4]/div[3]/div[2]/div[1]/div[1]/a[1]/img\n"));
//        var title = newsImg.getAttribute("title");
//
//        var filterButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[4]/div[1]/div/div[1]/div/button"));
//        filterButton.click();
//
//
//        var inputField = Util.getElementBySelector(driver, By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/input\n"));
//        inputField.clear();
//        inputField.sendKeys(title);
//
//        var checkBox = Util.getElementBySelector(driver, By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div/div/div/div\n"));
//        checkBox.click();
//
//        var closeButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[2]/div[2]/div[1]/button\n"));
//        closeButton.click();
//    }
//
//    public MainPage searchNews(String text) {
//        var searchInput = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[4]/div[1]/div/div[2]/div/div/input\n"));
//
//        searchInput.click();
//        searchInput.clear();
//        searchInput.sendKeys(text);
//
//        var searchButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[4]/div[1]/div/div/div/div/div[2]/button\n"));
//        searchButton.click();
//
//        return new MainPage(this.driver);
//    }

}
