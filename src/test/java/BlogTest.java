//import org.example.Util;
//import org.example.models.MainPage;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DynamicTest;
//import org.junit.jupiter.api.TestFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.util.stream.Stream;
//
//
//public class BlogTest {
//
//    @BeforeAll
//    static void prepareDrivers() {
//        Util.prepareDrivers();
//    }
//
//
//    //Тест на просмотр статистики
//    @TestFactory
//    public Stream<DynamicTest> testCheckStatistics() {
//        return Util.getDrivers().stream().map(driver -> DynamicTest.dynamicTest("Просмотр статистики в браузере " + driver.getClass(),
//                () -> {
//                    try {
//                        driver.manage().deleteAllCookies();
//                        MainPage mainPage = new MainPage(driver);
//                        driver.get(Util.BASE_URL);
//                        var loginPage = mainPage.goToLoginPage();
//                        var profilePage = loginPage.login(Util.CORRECT_EMAIL, Util.CORRECT_PASSWORD);
//
//                        profilePage = profilePage.pages();
//                        profilePage.pagesAdd();
////                        Assertions.assertTrue(profilePage.getDriver().getCurrentUrl().contains("https://wordpress.com/stats/day/mgribov259.wordpress.com"));
//                    } finally {
//                        driver.quit();
//                    }
//                }));
//    }
//}

//TODO: заброшено, пока не разберусь, как добираться до модальных окон