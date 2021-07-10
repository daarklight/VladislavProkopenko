package ru.training.at.hw4.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;
import ru.training.at.hw4.commons.PrepostConditionsHW4;
import ru.training.at.hw4.resources.DataProvidersForExercise2TestHW4;

@Feature("TestNG is used as testing framework")
public class Exercise2TestHW4 extends PrepostConditionsHW4 {

    @Story("Test for Exercise 2")
    @Test(dataProviderClass = DataProvidersForExercise2TestHW4.class, dataProvider = "Data for Exercise2Test")
    public void testExercise2Test(
        String mainPageURL, String titleForMainPage, String username, String password,
        String displayedUsername, String colorFromDropdown, List<String> expectedLogRowsTexts) {

        // 1. Open test site by URL
        stepsExercise2.openSite(mainPageURL);

        // 2. Assert Browser title
        stepsExercise2.checkIfBrowserTitleIsCorrect(titleForMainPage);

        // 3. Perform login
        stepsExercise2.performLogin(username, password);

        // 4. Assert Username is logged in
        stepsExercise2.checkDisplayedUsername(displayedUsername);

        // 5. Open through the header menu Service -> Different Elements Page
        stepsExercise2.openDifferentElementsPage();

        // 6. Select checkboxes
        stepsExercise2.selectCheckboxes();

        // 7. Select radio
        stepsExercise2.selectRadioButton();

        // 8. Select in dropdown
        stepsExercise2.selectInDropdown(colorFromDropdown);

        // 9. Assert that:
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox;
        // - for radio button there is a log row and value is corresponded to the status of radio button;
        // - for dropdown there is a log row and value is corresponded to the selected value;
        stepsExercise2.assertThatLogsAreCorrect(expectedLogRowsTexts);
    }
}

