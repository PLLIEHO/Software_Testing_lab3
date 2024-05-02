
import org.example.Util;
import org.example.models.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;


public class ProfilePageTest {

    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }


    //Тест на просмотр статистики
    @TestFactory
    public Stream<DynamicTest> testCheckStatistics() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Просмотр статистики в браузере " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        profilePage.statistics();
                        Assertions.assertTrue(profilePage.getDriver().getCurrentUrl().contains("https://wordpress.com/stats/day/mgribov259.wordpress.com"));
                    } finally {
                        driver.quit();
                    }
                }));
    }

    //Тест на просмотр статистики за последние 7 дней
    @TestFactory
    public Stream<DynamicTest> testCheckStatisticsForSevenDays() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Просмотр статистики в браузере " + driver.getClass(),
                () -> {
                    try {
                        //логинимся
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        //переходим на страницу статистики
                        profilePage = profilePage.statistics();
                        //выбираем 7 дней в селекторе
                        profilePage.statisticsFor7days();
                        //результат подгружается долго, нужен отбой
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        WebElement statsSelector = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/div/div[5]/div[1]/div/div[2]/div[1]/div/button\n"));
                        //проверяем что заголовок селектора изменился
                        Assertions.assertTrue(statsSelector.getText().contains("Последние 7 дней"));
                    } finally {
                        driver.quit();
                    }
                }));
    }


    //Тест на просмотр статистики тенденций в среднем за день
    @TestFactory
    public Stream<DynamicTest> testCheckDailyTendencies() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Просмотр тенденций в браузере " + driver.getClass(),
                () -> {
                    try {
                        //логинимся
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        //переходим на страницу статистики
                        profilePage = profilePage.statistics();
                        //выбираем тенденции
                        profilePage = profilePage.tendencies();
                        //выбираем в среднем за день
                        profilePage.tendenciesDaily();
                        //результат подгружается долго, нужен отбой
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        WebElement statsSelector = Util.getElementBySelector(driver, By.xpath("//a[@data-e2e-value='average']\n"));
                        //проверяем что кнопка зажглась
                        Assertions.assertEquals("true", statsSelector.getAttribute("aria-checked"));
                    } finally {
                        driver.quit();
                    }
                }));
    }

    //#add-subscribers

    //Тест на импорт подписчиков
    @TestFactory
    public Stream<DynamicTest> testImportSubs() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Окно импорта подписчиков " + driver.getClass(),
                () -> {
                    try {
                        //логинимся
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        //переходим на страницу статистики
                        profilePage = profilePage.statistics();
                        //выбираем подписчиков
                        profilePage = profilePage.subscribers();
                        //выбираем импорт
                        profilePage.subscribersImport();
                        //результат подгружается долго, нужен отбой
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //проверяем что ссылка поменялась
                        Assertions.assertTrue(profilePage.getDriver().getCurrentUrl().contains("add-subscribers"));
                    } finally {
                        driver.quit();
                    }
                }));
    }

    //Тест на просмотр своих покупок
    @TestFactory
    public Stream<DynamicTest> testPaid() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Окно покупок " + driver.getClass(),
                () -> {
                    try {
                        //логинимся
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        //переходим на страницу платных услуг
                        profilePage = profilePage.paid();
                        //выбираем покупки
                        profilePage.paidCustoms();
                        //результат подгружается долго, нужен отбой
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //проверяем что ссылка поменялась
                        Assertions.assertTrue(profilePage.getDriver().getCurrentUrl().contains("https://wordpress.com/purchases/subscriptions/mgribov259.wordpress.com"));
                    } finally {
                        driver.quit();
                    }
                }));
    }

    //Тест на сравнение тарифных планов
    @TestFactory
    public Stream<DynamicTest> testPaidPlans() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Окно тарифных планов " + driver.getClass(),
                () -> {
                    try {
                        //логинимся
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        //переходим на страницу платных услуг
                        profilePage = profilePage.paid();
                        //выбираем покупки
                        profilePage.paidCompare();
                        //результат подгружается долго, нужен отбой
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //проверяем что появилась надпись
                        WebElement statsSelector = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div/div/main/div/div[2]/div/div[3]/h1\n"));
                        Assertions.assertEquals("Сравните наши тарифы и найдите ваш", statsSelector.getText());
                    } finally {
                        driver.quit();
                    }
                }));
    }
}