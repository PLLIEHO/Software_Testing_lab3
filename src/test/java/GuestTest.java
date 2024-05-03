
import org.example.Util;
import org.example.models.FeaturesPage;
import org.example.models.MainPage;
import org.example.models.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;


public class GuestTest {

    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }


    //Тест на просмотр страницы "инженеры поддержки"
    @TestFactory
    public Stream<DynamicTest> testEngineers() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Просмотр страницы \"инженеры поддержки\" " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        FeaturesPage featuresPage = mainPage.goToFeaturesPage();

                        Assertions.assertTrue(featuresPage.getDriver().getCurrentUrl().contains("https://wordpress.com/ru/features"));

                        Page page = featuresPage.goToSupportEngineers();
                        Assertions.assertTrue(page.getDriver().getCurrentUrl().contains("https://wordpress.com/ru/expert-support/"));

                    } finally {
                        driver.quit();
                    }
                }));
    }
}