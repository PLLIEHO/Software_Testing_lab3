import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mikhail.Utils;
import ru.mikhail.models.MainPage;

import java.io.IOException;
import java.util.stream.Stream;

public class ProfilePageTest {
    // Тест на просмотр статистики
    @TestFactory
    public Stream<DynamicTest> testCheckStatistics() throws IOException {
        return TestUtils.boilerplate("Просмотр статистики в браузере", (driver, driverManager) -> {
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            profilePage.statistics();
            Assertions.assertTrue(driver.getCurrentUrl().contains("https://wordpress.com/stats/day/mgribov259.wordpress.com"));
        });
    }

    // Тест на просмотр статистики за последние 7 дней
    @TestFactory
    public Stream<DynamicTest> testCheckStatisticsForSevenDays() throws IOException {
        return TestUtils.boilerplate("Просмотр статистики в браузере", (driver, driverManager) -> {
            //логинимся
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            //переходим на страницу статистики
            profilePage = profilePage.statistics();
            //выбираем 7 дней в селекторе
            profilePage.statisticsFor7days();
            //результат подгружается долго, нужен отбой
            Utils.sleep(1000);
            WebElement statsSelector = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[6]/div[1]/div/div[2]/div[1]/div/button"));
            //проверяем что заголовок селектора изменился
            Assertions.assertTrue(statsSelector.getText().contains("Последние 7 дней"));
        });
    }


    //Тест на просмотр статистики тенденций в среднем за день
    @TestFactory
    public Stream<DynamicTest> testCheckDailyTendencies() throws IOException {
        return TestUtils.boilerplate("Просмотр тенденций в браузере", (driver, driverManager) -> {
            //логинимся
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            //переходим на страницу статистики
            profilePage = profilePage.statistics();
            //выбираем тенденции
            profilePage = profilePage.tendencies();
            //выбираем в среднем за день
            profilePage.tendenciesDaily();
            //результат подгружается долго, нужен отбой
            Utils.sleep(1000);
            WebElement statsSelector = Utils.getElementBySelector(driver, By.xpath("//a[@data-e2e-value='average']"));
            //проверяем что кнопка зажглась
            Assertions.assertEquals("true", statsSelector.getAttribute("aria-checked"));
        });
    }

    //Тест на импорт подписчиков
    @TestFactory
    public Stream<DynamicTest> testImportSubs() throws IOException {
        return TestUtils.boilerplate("Просмотр тенденций в браузере", (driver, driverManager) -> {
            //логинимся
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            //переходим на страницу статистики
            profilePage = profilePage.statistics();
            //выбираем подписчиков
            profilePage = profilePage.subscribers();
            //выбираем импорт
            profilePage.subscribersImport();
            //результат подгружается долго, нужен отбой
            Utils.sleep(1000);
            //проверяем что ссылка поменялась
            Assertions.assertTrue(driver.getCurrentUrl().contains("add-subscribers"));
        });
    }

    //Тест на просмотр своих покупок
    @TestFactory
    public Stream<DynamicTest> testPaid() throws IOException {
        return TestUtils.boilerplate("Просмотр тенденций в браузере", (driver, driverManager) -> {
            //логинимся
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            //переходим на страницу платных услуг
            profilePage = profilePage.paid();
            //выбираем покупки
            profilePage.paidCustoms();
            //результат подгружается долго, нужен отбой
            Utils.sleep(1000);
            //проверяем что ссылка поменялась
            Assertions.assertTrue(driver.getCurrentUrl().contains("https://wordpress.com/purchases/subscriptions/mgribov259.wordpress.com"));
        });
    }

    //Тест на сравнение тарифных планов
    @TestFactory
    public Stream<DynamicTest> testPaidPlans() throws IOException {
        return TestUtils.boilerplate("Просмотр тенденций в браузере", (driver, driverManager) -> {
            //логинимся
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            var profilePage = loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());

            //переходим на страницу платных услуг
            profilePage = profilePage.paid();
            //выбираем покупки
            profilePage.paidCompare();
            //результат подгружается долго, нужен отбой
            Utils.sleep(1000);
            //проверяем что появилась надпись
            WebElement statsSelector = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/main/div/div[2]/div/div[3]/h1\n"));
            Assertions.assertEquals("Сравните наши тарифы и найдите ваш", statsSelector.getText());
        });
    }
}