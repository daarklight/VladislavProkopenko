package ru.training.at.hw7jdi.tests;

import static pages.hw7jdi.site.JdiSite.metalsAndColorsPage;
import static pages.hw7jdi.site.pages.HomePage.metalsColors;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.metalsColorsForm;

import org.testng.annotations.Test;
import pages.hw7jdi.entities.MetalsColorsModel;
import ru.training.at.hw7jdi.data.MetalsColorsDataProvider;

public class MainTest implements TestInit {

    @Test(dataProvider = "metalsColorsObjects", dataProviderClass = MetalsColorsDataProvider.class)
    public void mainTest(MetalsColorsModel metalsColorsModel) {

        // Open Metals & Colors Page:
        metalsColors.click();

        // Fill Metals & Colors Form and check results:
        metalsAndColorsPage.shouldBeOpened();
        metalsColorsForm.fill(metalsColorsModel);
        metalsColorsForm.submit();
        metalsColorsForm.verifyIfResultsAreCorrect(metalsColorsModel);
    }
}
