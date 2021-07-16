package ru.training.at.hw7jdi.tests;

import static pages.hw7jdi.site.JdiSite.homePage;
import static pages.hw7jdi.site.pages.HomePage.loginForm;
import static pages.hw7jdi.site.pages.HomePage.metalsColors;
import static pages.hw7jdi.site.pages.HomePage.userIcon;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.colorsDropdown;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.elementsChecklist;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.metalsDropdown;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.submitButton;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.summaryRadiobuttonBottomLine;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.summaryRadiobuttonTopLine;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.vegetablesDropdown;
import static ru.training.at.hw7jdi.data.UserData.DEFAULT_USER;

import java.util.List;
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
        metalsColors.click();

        // Fill Summary
        summaryRadiobuttonTopLine.select(String.valueOf(3));
        summaryRadiobuttonBottomLine.select(String.valueOf(8));

        // Fill Metals & Colors

        colorsDropdown.select("Yellow");
        metalsDropdown.select("Gold");

        vegetablesDropdown.select("Vegetables");
        vegetablesDropdown.select("Cucumber", "Tomato");

        // Fill checklist of Elements
        elementsChecklist.select("Water", "Wind");


        // Submit Metals & Colors form
        submitButton.click();

        // Check submitted results
    }
}
