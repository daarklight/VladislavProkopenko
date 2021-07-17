package ru.training.at.hw7jdi.states;

import static pages.hw7jdi.site.JdiSite.logout;
import static pages.hw7jdi.site.JdiSite.userName;
import static pages.hw7jdi.site.pages.HomePage.loginForm;
import static pages.hw7jdi.site.pages.HomePage.userIcon;

import io.qameta.allure.Step;

public class States {

    @Step
    public static void shouldBeLoggedOut() {
        if (userName.isDisplayed()) {
            logout();
        }
        if (loginForm.isDisplayed()) {
            userIcon.click();
        }
    }

    @Step
    public static void logout() {
        if (!logout.isDisplayed()) {
            userIcon.click();
        }
        logout.click();
    }
}
