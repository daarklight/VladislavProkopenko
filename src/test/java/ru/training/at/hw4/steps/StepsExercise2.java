package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepsExercise2 extends AbstractSteps {

    public StepsExercise2(WebDriver webdriver) {
        super(webdriver);
    }

    @Step("Open test site by URL")
    public void openSite(String siteURL) {
        commonPageContent.openPage(siteURL);
    }

    @Step("Assert Browser title")
    public void checkIfBrowserTitleIsCorrect(String pageTitle) {
        Assert.assertEquals(commonPageContent.checkPageTitle(), pageTitle);
    }

    @Step("Perform login")
    public void performLogin(String username, String password) {
        loginFields.login(username, password);
    }

    @Step("Assert Username is logged in")
    public void checkDisplayedUsername(String displayedUsername) {
        loginFields.checkIfUsernameIsLoggedIn(displayedUsername);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        headerMenu.clickDifferentElements();
    }

    @Step("Select checkboxes")
    public void selectCheckboxes() {
        buttonsAndDropdownArea.clickCheckBoxes();
    }

    @Step("Select radio")
    public void selectRadioButton() {
        buttonsAndDropdownArea.clickRadioButton();
    }

    @Step("Select in dropdown")
    public void selectInDropdown(String dropdownColor) {
        buttonsAndDropdownArea.selectDropdown(dropdownColor);
    }

    @Step("AssertThatLogsAreCorrect")
    public void assertThatLogsAreCorrect(List<String> expectedLogRowsTexts) {
        Assert.assertEquals(logArea.transferListOfLogRowsTexts(), expectedLogRowsTexts);
    }
}

