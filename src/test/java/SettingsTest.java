import org.example.Util;
import org.example.models.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;


public class SettingsTest {

    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }

    //Тест на смену языка интерфейса
    @TestFactory
    public Stream<DynamicTest> changeLanguageTest() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Смена языка в браузере " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        var settingsPage = profilePage.goToSettings();
                        settingsPage.profileSettings();
                        settingsPage.changeLanguageToEng();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        //проверяем что надпись изменилась
                        WebElement statsSelector = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/header/div/div/header/div/p\n"));
                        Assertions.assertEquals("Adjust your account information and interface settings. Learn more.", statsSelector.getText());
//
//                        settingsPage.changeLanguageToRus();
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        WebElement rusSelector = Util.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[3]/div[2]/main/header/div/div/header/div/p\n"));
//                        Assertions.assertEquals("Измените данные вашей учётной записи и настройки интерфейса. Подробнее.", rusSelector.getText());
                    } finally {
                        driver.quit();
                    }
                }));
    }

    //Тест на выход из аккаунта
    @TestFactory
    public Stream<DynamicTest> logoutTest() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Выход из аккаунта в браузере " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);

                        var settingsPage = profilePage.goToSettings();
                        mainPage = settingsPage.exit();

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }


                        //проверяем что ссылка изменилась
                        Assertions.assertTrue(profilePage.getDriver().getCurrentUrl().contains("https://wordpress.com/ru/?apppromo"));
                    } finally {
                        driver.quit();
                    }
                }));
    }
}