package ru.mikhail;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class DriverManager {
    private final String url;
    private final String correctEmail;
    private final String correctPassword;
    private final String wrongPassword;
    private final List<RemoteWebDriver> webDrivers = new ArrayList<>();
    @Getter(AccessLevel.NONE) private final Map<String, String> params;

    public DriverManager() throws IOException {
        params = Files.readAllLines(Paths.get("wordpress.properties"))
                .stream()
                .map(line -> line.split("=", 2))
                .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
        if (params.get("firefox-path") != null) {
            System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, params.get("firefox-path"));
        }
        if (params.get("chrome-path") != null) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, params.get("chrome-path"));
        }
        switch (params.get("web-driver")) {
            case "firefox" -> webDrivers.add(firefoxDriver());
            case "chrome" -> webDrivers.add(chromeDriver());
            case "both" -> webDrivers.addAll(List.of(firefoxDriver(), chromeDriver()));
            default -> throw new RemoteException("Incorrect 'web-driver' parameter. Should be in [firefox, chrome, both].");
        }
        this.url = params.get("url");
        this.correctEmail = params.get("correct-email");
        this.correctPassword = params.get("correct-password");
        this.wrongPassword = params.get("wrong-password");
    }

    private ChromeDriver chromeDriver() {
        if (!System.getProperties().containsKey(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY)) {
            throw new RuntimeException("Chrome driver not set properly");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "C:\\Users\\User\\IdeaProjects\\SeleniumTest\\files");
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(options);
    }

    private FirefoxDriver firefoxDriver() {
        if (!System.getProperties().containsKey(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY)) {
            throw new RuntimeException("Firefox driver not set properly");
        }
        return new FirefoxDriver();
    }
}
