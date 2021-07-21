package ru.training.at.hw7jdi.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static pages.hw7jdi.site.JdiSite.homePage;
import static pages.hw7jdi.site.pages.HomePage.loginForm;
import static pages.hw7jdi.site.pages.HomePage.userIcon;
import static ru.training.at.hw7jdi.data.UserData.getDefaultUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.hw7jdi.site.JdiSite;

public interface TestInit {

    @BeforeTest(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        openSite(JdiSite.class);

        // Login:
        homePage.open();
        userIcon.click();
        loginForm.loginAs(getDefaultUser());
        homePage.checkOpened();

        logger.info("Run Tests");
    }

    @AfterTest(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
