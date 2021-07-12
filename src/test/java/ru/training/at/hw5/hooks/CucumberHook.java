package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.hw5.driver.WebDriverSingleton;
import ru.training.at.hw5.context.TestContext;

public class CucumberHook {

    @Before
    public void initDriver() {
        WebDriverSingleton.getDriver();
    }

    @After
    public void closeDriver() {
        WebDriverSingleton.closeDriver();
        TestContext.getInstance().clean();
    }

}
