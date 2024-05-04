package ru.mikhail.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mikhail.Utils;

public class FeaturesPage extends Page {
    public FeaturesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void goToSupportEngineers() {
        WebElement supButton = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[3]/div/section[5]/div[2]/section[1]/div/p/a"));
        supButton.click();
    }
}
