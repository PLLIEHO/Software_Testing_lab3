import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mikhail.Utils;
import ru.mikhail.models.MainPage;

import java.io.IOException;
import java.util.stream.Stream;

public class SettingsTest {
    //Тест на смену языка интерфейса
    @TestFactory
    public Stream<DynamicTest> changeLanguageTest() throws IOException {
        return TestUtils.boilerplate("Смена языка в браузере", (driver, driverManager) -> {
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            var settingsPage = profilePage.goToSettings();
            settingsPage.profileSettings();
            settingsPage.changeLanguageToEng();

            Utils.sleep(1000);

            //проверяем что надпись изменилась
            WebElement statsSelector = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[3]/main/header/div/div/header/div/p"));
            Assertions.assertEquals("Adjust your account information and interface settings. Learn more.", statsSelector.getText());

            settingsPage.changeLanguageToRus();
            Utils.sleep(1000);
            WebElement rusSelector = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[3]/main/header/div/div/header/div/p"));
            Assertions.assertEquals("Измените данные вашей учётной записи и настройки интерфейса. Подробнее.", rusSelector.getText());
        });
    }

    //Тест на выход из аккаунта
    @TestFactory
    public Stream<DynamicTest> logoutTest() throws IOException {
        return TestUtils.boilerplate("Выход из аккаунта в браузере", (driver, driverManager) -> {
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            var settingsPage = profilePage.goToSettings();
            settingsPage.exit();

            Utils.sleep(1000);

            //проверяем что ссылка изменилась
            Assertions.assertTrue(driver.getCurrentUrl().contains("https://wordpress.com/ru/?apppromo"));
        });
    }
}