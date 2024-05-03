package org.example.models;

import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProfilePage extends Page{

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    public ProfilePage statistics(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement statsButton = Util.getElementBySelector(driver, By.xpath("//span[@data-e2e-sidebar='Статистика']\n"));
        statsButton.click();

        return new ProfilePage(this.driver);
    }

    public void statisticsFor7days(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement selector = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[5]/div[1]/div/div[2]/div[1]/div/button\n"));
        selector.click();
        Util.waitUntilPageLoads(driver, 10);
        WebElement statsSelector = Util.getElementBySelector(driver, By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/ul/li[1]/button\n"));
        statsSelector.click();
        Util.waitUntilPageLoads(driver, 100);
    }

    public ProfilePage tendencies(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement tenButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[2]/div[1]/div/div/div/ul/li[2]/a\n"));
        tenButton.click();

        return new ProfilePage(this.driver);
    }

    public void tendenciesDaily(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement tenButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[5]/div/div/div/div[1]/ul/li[2]/a\n"));
        tenButton.click();
    }

    public ProfilePage subscribers(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement subButton = Util.getElementBySelector(driver, By.xpath("//a[@href='/stats/subscribers/mgribov259.wordpress.com']\n"));
        subButton.click();

        return new ProfilePage(this.driver);
    }

    public void subscribersImport(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement importButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[2]/div[2]/ul/li[1]/a\n"));
        importButton.click();
    }

    public ProfilePage paid(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement paidButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul/li[4]/ul/li[1]/a/span[2]\n"));
        paidButton.click();

        return new ProfilePage(this.driver);
    }

    public void paidCompare(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement paidButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/main/div/div[2]/div/div[2]/button\n"));
        paidButton.click();
    }

    public void paidCustoms(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement paidButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul/li[4]/ul/li[2]/ul/li[5]/a\n"));
        paidButton.click();
    }

    public ProfilePage pages(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement blogButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul/li[8]/ul/li[1]/a/span[2]\n"));
        blogButton.click();

        return new ProfilePage(this.driver);
    }

    public SettingsPage goToSettings(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement setButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[1]/header/div[3]/a[1]/span/img\n"));
        setButton.click();

        return new SettingsPage(this.driver);
    }
//TODO: разобраться, как через XPath доковыряться до модального окна, открытого в отдельном #document

//    public void pagesAdd(){
//        Util.waitUntilPageLoads(driver, 10);
//        WebElement pagesButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div[2]/div/div[1]/div[2]/a\n"));
//        pagesButton.click();
//
//        Util.waitUntilPageLoads(driver, 1000);
//        Util.waitUntilPageLoads(driver, 5000);
//
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(0));
//        Util.getElementBySelector(driver, By.xpath("//button[contains(@class, 'page-pattern-modal__blank-button is-secondary')]\n")).click();
//
//
//
//    }
}
