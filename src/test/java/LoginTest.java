
import org.example.Util;
import org.example.models.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;

import java.util.stream.Stream;


public class LoginTest {

    @BeforeAll
    static void prepareDrivers() {
        Util.prepareDrivers();
    }


    //Тест на вход с правильными данными
    @TestFactory
    public Stream<DynamicTest> testLoginWithMail() {
        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Успешный вход в аккаунт в браузере " + driver.getClass(),
                () -> {
                    try {
                        driver.manage().deleteAllCookies();
                        MainPage mainPage = new MainPage(driver);
                        driver.get(Util.BASE_URL);
                        var loginPage = mainPage.goToLoginPage();
                        loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);
                        Assertions.assertTrue(loginPage.getDriver().getCurrentUrl().contains("https://wordpress.com/home/mgribov259.wordpress.com"));
                    } finally {
                        driver.quit();
                    }
                }));
    }

}