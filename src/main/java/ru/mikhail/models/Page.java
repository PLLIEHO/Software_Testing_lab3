package ru.mikhail.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.remote.RemoteWebDriver;

@Getter
@Setter
@AllArgsConstructor
public class Page {
    protected RemoteWebDriver driver;
}