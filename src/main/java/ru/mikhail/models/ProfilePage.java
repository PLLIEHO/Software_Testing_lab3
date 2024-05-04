package ru.mikhail.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mikhail.Utils;

public class ProfilePage extends Page {
    public ProfilePage(RemoteWebDriver driver) {
        super(driver);
    }

    public ProfilePage statistics() {
        WebElement statsButton = Utils.getElementBySelector(driver, By.xpath("//span[@data-e2e-sidebar='Статистика']"));
        statsButton.click();

        return new ProfilePage(this.driver);
    }

    public void statisticsFor7days() {
        WebElement selector = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[6]/div[1]/div/div[2]/div[1]/div/button"));
        selector.click();
        WebElement statsSelector = Utils.getElementBySelector(driver, By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/ul/li[1]/button"));
        statsSelector.click();
    }

    public ProfilePage tendencies() {
        WebElement tenButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[2]/div[1]/div/div/div/ul/li[2]/a"));
        tenButton.click();

        return new ProfilePage(this.driver);
    }

    public void tendenciesDaily() {
        WebElement tenButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[5]/div/div/div/div[1]/ul/li[2]/a"));
        tenButton.click();
    }

    public ProfilePage subscribers() {
        WebElement subButton = Utils.getElementBySelector(driver, By.xpath("//a[@href='/stats/subscribers/mgribov259.wordpress.com']"));
        subButton.click();

        return new ProfilePage(this.driver);
    }

    public void subscribersImport() {
        WebElement importButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[2]/div[2]/ul/li[1]/a"));
        importButton.click();
    }

    public ProfilePage paid() {
        WebElement paidButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul/li[4]/ul/li[1]/a/span[2]"));
        paidButton.click();

        return new ProfilePage(this.driver);
    }

    public void paidCompare() {
        WebElement paidButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/main/div/div[2]/div/div[2]/button"));
        paidButton.click();
    }

    public void paidCustoms() {
        WebElement paidButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul/li[4]/ul/li[2]/ul/li[5]/a"));
        paidButton.click();
    }

    public ProfilePage pages() {
        WebElement blogButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/ul/li[8]/ul/li[1]/a/span[2]"));
        blogButton.click();

        return new ProfilePage(this.driver);
    }

    public SettingsPage goToSettings() {
        WebElement setButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[1]/header/div[3]/a[1]/span/img"));
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
