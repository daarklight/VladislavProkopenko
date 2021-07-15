package ru.training.at.hw7jdi.tests;

import static pages.hw7jdi.site.JdiSite.homePage;
import static pages.hw7jdi.site.pages.HomePage.loginForm;
import static pages.hw7jdi.site.pages.HomePage.userIcon;
import static ru.training.at.hw7jdi.data.UserData.DEFAULT_USER;

import org.testng.annotations.Test;

public class MainTest implements TestInit {

    @Test
    public void mainTest() {
        // Login:
        homePage.open();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();

        // Open Metals & Colors

        // Fill Metals & Colors

        // Submit Metals & Colors form

        // Check submitted results
    }
}
