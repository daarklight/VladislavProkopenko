package ru.training.at.hw4.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw4.steps.StepsExercise1;
import ru.training.at.hw4.steps.StepsExercise2;

public class PrepostConditions {

    protected WebDriver webdriver;
    public StepsExercise1 stepsExercise1;
    public StepsExercise2 stepsExercise2;

    @BeforeClass
    public void setUpClass(ITestContext testContext) throws IOException {

        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webdriver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(3));

        webdriver.manage().window().maximize();

        testContext.setAttribute("webdriver", webdriver);

        stepsExercise1 = new StepsExercise1(webdriver);
        stepsExercise2 = new StepsExercise2(webdriver);
    }

    // Close Browser
    @AfterClass
    public void closing() {
        webdriver.close();
    }
}
