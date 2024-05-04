import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;
import ru.mikhail.Utils;
import ru.mikhail.models.FeaturesPage;
import ru.mikhail.models.MainPage;

import java.io.IOException;
import java.util.stream.Stream;

public class GuestTest {
    //Тест на просмотр страницы "инженеры поддержки"
    @TestFactory
    public Stream<DynamicTest> testEngineers() throws IOException {
        return TestUtils.boilerplate("Просмотр страницы \"инженеры поддержки\"", (driver, driverManager) -> {
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            FeaturesPage featuresPage = mainPage.goToFeaturesPage();

            Assertions.assertTrue(driver.getCurrentUrl().contains("https://wordpress.com/ru/features"));

            featuresPage.goToSupportEngineers();
            Assertions.assertTrue(driver.getCurrentUrl().contains("https://wordpress.com/ru/expert-support/"));
        });
    }

    // Тест на просмотр страницы с руководствами
    @TestFactory
    public Stream<DynamicTest> testSupport() throws IOException {
        return TestUtils.boilerplate("Просмотр страницы с руководствами", (driver, driverManager) -> {
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            mainPage.goToSupportPage();

            Assertions.assertTrue(driver.getCurrentUrl().contains("https://wordpress.com/ru/support"));
            var subTitle = Utils.getElementBySelector(driver, By.xpath("/html/body/div[3]/div/div/div/p"));
            Assertions.assertEquals("Находите ресурсы поддержки и документацию для WordPress.com", subTitle.getText());
        });
    }
}