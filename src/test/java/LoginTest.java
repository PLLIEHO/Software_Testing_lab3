import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.openqa.selenium.By;
import ru.mikhail.Utils;
import ru.mikhail.models.MainPage;

import java.io.IOException;
import java.util.stream.Stream;

public class LoginTest {
    // Тест на вход с правильными данными
    @TestFactory
    public Stream<DynamicTest> testLoginWithMail() throws IOException {
        return TestUtils.boilerplate("Успешный вход в аккаунт в браузере", (driver, driverManager) -> {
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            loginPage.login(driverManager.getCorrectEmail(), driverManager.getCorrectPassword());
            Utils.sleep(2000);
            Assertions.assertTrue(driver.getCurrentUrl().contains("https://wordpress.com/home/mgribov259.wordpress.com"));
        });
    }

    // Тест на вход с неправильными данными
    @TestFactory
    public Stream<DynamicTest> testIncorrectLoginWithMail() throws IOException {
        return TestUtils.boilerplate("Безуспешный вход в аккаунт в браузере", (driver, driverManager) -> {
            MainPage mainPage = new MainPage(driver);
            driver.get(driverManager.getUrl());
            var loginPage = mainPage.goToLoginPage();
            loginPage.login(driverManager.getCorrectEmail(), driverManager.getWrongPassword());
            Utils.sleep(2000);
            var span = Utils.getElementBySelector(driver, By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/main/div[3]/div/form/div[1]/div[1]/div/div[2]/span"));
            Assertions.assertEquals("Кажется, вы ввели неправильный пароль. Хотите получить ссылку для входа по электронной почте?", span.getText());
        });
    }
}