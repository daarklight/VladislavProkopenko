package ru.training.at.hw3.ex2;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.differentelementspage.ButtonsAndDropdownArea;
import pages.differentelementspage.LogArea;
import pages.mainpage.HeaderMenu;
import pages.mainpage.LoginFields;
import ru.training.at.hw3.commonsteps.PrepostConditions;

public class Exercise2Test extends PrepostConditions {

    public static final int numberOfUniqueElement = 1;

    @Test
    public void exercise1Test() {

        // 2. Assert Browser title
        Assert.assertEquals(webdriver.getTitle(), properties.getProperty("titleForMainPage"));

        // 3. Perform login
        LoginFields loginFields = PageFactory.initElements(webdriver, LoginFields.class);
        loginFields.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is logged in
        Assert.assertEquals(loginFields.getDisplayedUserName(), properties.getProperty("displayedUserName"));

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
        buttonsAndDropdownArea.selectDropdown(properties.getProperty("colorFromDropdown"));

        // 9. Assert that:
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox;
        // - for radio button there is a log row and value is corresponded to the status of radio button;
        // - for dropdown there is a log row and value is corresponded to the selected value;
        LogArea logArea = PageFactory.initElements(webdriver, LogArea.class);
        Assert.assertTrue(logArea.checkIfLogRowsAreUniqueForButtonsAndDropdown());
    }
}
