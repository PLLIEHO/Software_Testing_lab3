package org.example.models;

import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FeaturesPage extends Page {
    public FeaturesPage(WebDriver driver) {
        super(driver);
    }

    public Page goToSupportEngineers(){
        Util.waitUntilPageLoads(driver, 10);
        WebElement supButton = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div[3]/div/section[5]/div[2]/section[1]/div/p/a\n"));
        supButton.click();

        return new Page(this.driver);
    }
}
