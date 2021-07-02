package ru.training.at.hw3.ex2;

import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.differentelementspage.ButtonsAndDropdownArea;
import pages.differentelementspage.LogArea;
import pages.mainpage.HeaderMenu;
import pages.mainpage.LoginFields;
import ru.training.at.hw3.commonsteps.PrepostConditions;
import ru.training.at.hw3.resources.DataProvidersForExercise2Test;

public class Exercise2Test extends PrepostConditions {

    @Test(dataProviderClass = DataProvidersForExercise2Test.class, dataProvider = "Data for Exercise2Test")
    public void testExercise2Test(
        String mainPageURL, String titleForMainPage, String username, String password,
        String displayedUsername, String colorFromDropdown, List<String> expectedLogRowsTexts) {

        // 1. Open test site by URL
        webdriver.navigate().to(mainPageURL);

        // 2. Assert Browser title
        Assert.assertEquals(webdriver.getTitle(), titleForMainPage);

        // 3. Perform login
        LoginFields loginFields = PageFactory.initElements(webdriver, LoginFields.class);
        loginFields.login(username, password);

        // 4. Assert Username is logged in
        loginFields.checkIfUsernameIsLoggedIn(displayedUsername);

        // 5. Open through the header menu Service -> Different Elements Page
        HeaderMenu headerMenu = PageFactory.initElements(webdriver, HeaderMenu.class);
        headerMenu.clickDifferentElements();

        // 6. Select checkboxes
        ButtonsAndDropdownArea buttonsAndDropdownArea =
            PageFactory.initElements(webdriver, ButtonsAndDropdownArea.class);
        buttonsAndDropdownArea.clickCheckBoxes();

        // 7. Select radio
        buttonsAndDropdownArea.clickRadioButton();

        // 8. Select in dropdown
        buttonsAndDropdownArea.selectDropdown(colorFromDropdown);

        // 9. Assert that:
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox;
        // - for radio button there is a log row and value is corresponded to the status of radio button;
        // - for dropdown there is a log row and value is corresponded to the selected value;
        LogArea logArea = PageFactory.initElements(webdriver, LogArea.class);
        Assert.assertEquals(logArea.transferListOfLogRowsTexts(), expectedLogRowsTexts);
    }
}
