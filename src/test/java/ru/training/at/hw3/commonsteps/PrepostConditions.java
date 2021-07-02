package ru.training.at.hw3.commonsteps;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PrepostConditions {

    protected WebDriver webdriver;

    @BeforeClass
    public void setUpClass() throws IOException {

        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webdriver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(3));

        webdriver.manage().window().maximize();
    }

    // Close Browser
    @AfterClass
    public void closing() {
        webdriver.close();
    }
}
