package ru.training.at.hw4.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;
import ru.training.at.hw4.commons.PrepostConditionsHW4;
import ru.training.at.hw4.resources.DataProvidersForExercise1TestHW4;

@Feature("TestNG is used as testing framework")
public class Exercise1IncorrectTestHW4 extends PrepostConditionsHW4 {

    @Story("Incorrect Test for Exercise 1")
    @Test(dataProviderClass = DataProvidersForExercise1TestHW4.class, dataProvider = "Data for Exercise1Test")
    public void testExercise1IncorrectTest(
        String mainPageURL, String titleForMainPage, String username, String password,
        String displayedUsername, List<String> expectedNamesOfHeaderMenuItems,
        int expectedNumberOfTextFieldsAndImages, List<String> expectedBenefitTexts,
        String iframeName, List<String> expectedNamesOfLeftMenuItems) {

        // 1. Open test site by URL
        stepsExercise1.openSite(mainPageURL);

        // 2. Assert Browser title
        stepsExercise1.checkIfBrowserTitleIsCorrect(titleForMainPage);

        // 3. Perform login
        stepsExercise1.performLogin(username, password);

        // 4. Assert Username is logged in
        stepsExercise1.checkDisplayedUsername(displayedUsername);

        // 5. Assert that 4 items on the header section are displayed and have proper texts
        stepsExercise1.assertHeaderItemsAreDisplayedAndHaveProperTexts(expectedNamesOfHeaderMenuItems);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        stepsExercise1.assertNumberOfImagesAndIfTheyAreDisplayed(10);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // (According to teacher's recommendations, it was decided to exclude the requirement of
        // searching these 4 texts under the icons. So, each text is searched as is, without
        // any connections to points in space)
        stepsExercise1.assertThatBenefitTextsExistAndHaveProperContent(expectedBenefitTexts);

        // 8. Assert that the iframe with “Frame Button” exists
        // (Cause step #9 checks whether “Frame Button” exists in the iframe,
        // it was decided to check only existence of the frame)
        stepsExercise1.assertExistenceOfIframe();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        stepsExercise1.switchToIframeAndCheckExistenceOfIframeButton(iframeName);

        // 10. Switch to original window back
        stepsExercise1.switchToOriginalWindow();

        // 11. Assert that 5 items in the Left Section are displayed and have proper text
        stepsExercise1.assertThatLeftSectionItemsAreDisplayedAndHaveProperText(expectedNamesOfLeftMenuItems);
    }
}
