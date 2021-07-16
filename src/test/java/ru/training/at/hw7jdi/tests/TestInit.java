package ru.training.at.hw7jdi.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.hw7jdi.site.JdiSite;

public interface TestInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        openSite(JdiSite.class);
        logger.info("Run Tests");
    }

//    @AfterSuite(alwaysRun = true)
//    static void teardown() {
//        killAllSeleniumDrivers();
//    }

}
