package ru.training.at.hw4.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.training.at.hw4.steps.StepsExercise1HW4;
import ru.training.at.hw4.steps.StepsExercise2HW4;

public class PrepostConditionsHW4 {

    protected WebDriver webdriver;
    protected StepsExercise1HW4 stepsExercise1;
    protected StepsExercise2HW4 stepsExercise2;

    @BeforeClass
    public void setUpClass(ITestContext testContext) throws IOException {

        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver();

        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webdriver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(3));

        webdriver.manage().window().maximize();

        testContext.setAttribute("webdriver", webdriver);

        stepsExercise1 = new StepsExercise1HW4(webdriver);
        stepsExercise2 = new StepsExercise2HW4(webdriver);
    }

    // Close Browser
    @AfterClass
    public void closing() {
        webdriver.close();
    }
}
