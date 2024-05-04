import org.junit.jupiter.api.DynamicTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mikhail.DriverManager;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class TestUtils {
    public static Stream<DynamicTest> boilerplate(String title, BiConsumer<RemoteWebDriver,
            DriverManager> consumer) throws IOException {
        var driverManager = new DriverManager();
        return driverManager
                .getWebDrivers()
                .stream()
                .map(driver -> DynamicTest.dynamicTest(title + " " + driver.getClass(), () -> {
                            try {
                                consumer.accept(driver, driverManager);
                            } finally {
                                driver.quit();
                            }
                        }
                ));
    }
}
