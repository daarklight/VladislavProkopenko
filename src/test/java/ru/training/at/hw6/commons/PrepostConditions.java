package ru.training.at.hw6.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.hw6.driver.WebDriverSingleton;
import ru.training.at.hw6.steps.StepsExercise1;
import ru.training.at.hw6.steps.StepsExercise2;

public class PrepostConditions {

    protected WebDriver webdriver;
    protected StepsExercise1 stepsExercise1;
    protected StepsExercise2 stepsExercise2;

    @BeforeClass
    public void setUpClass(ITestContext testContext) throws IOException {

        WebDriverManager.chromedriver().setup();
        webdriver = WebDriverSingleton.getDriver();

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
        WebDriverSingleton.closeDriver();
    }
}
