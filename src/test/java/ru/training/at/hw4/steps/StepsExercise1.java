package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepsExercise1 extends AbstractSteps {

    public StepsExercise1(WebDriver webdriver) {
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

    @Step("Assert that 4 items on the header section are displayed and have proper texts")
    public void assertHeaderItemsAreDisplayedAndHaveProperTexts(List<String> expectedNamesOfHeaderMenuItems) {
        headerMenu.checkIfHeaderItemsAreDisplayed();
        Assert.assertEquals(headerMenu.transferListOfHeaderMenuItems(), expectedNamesOfHeaderMenuItems);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertNumberOfImagesAndIfTheyAreDisplayed(int expectedNumberOfTextFieldsAndImages) {
        bottomPicturesAndTexts.checkNumberOfImages(expectedNumberOfTextFieldsAndImages);
        bottomPicturesAndTexts.checkIfAllImagesAreDisplayed();
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertThatBenefitTextsExistAndHaveProperContent(List<String> expectedBenefitTexts) {
        Assert.assertEquals(bottomPicturesAndTexts.transferListOfBenefitTexts(),
            expectedBenefitTexts);
    }

    @Step("Assert that the iframe with “Frame Button” exists")
    public void assertExistenceOfIframe() {
        iframe.checkIfIframeExists();
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void switchToIframeAndCheckExistenceOfIframeButton(String iframeName) {
        iframe.switchToIframe(iframeName);
        iframe.checkIfIframeButtonExists();
    }

    @Step("Switch to original window back")
    public void switchToOriginalWindow() {
        commonPageContent.switchToMainPage();
    }

    @Step("Assert that 5 items in the Left Section are displayed and have proper text")
    public void assertThatLeftSectionItemsAreDisplayedAndHaveProperText(List<String> expectedNamesOfLeftMenuItems) {
        leftMenu.checkIfLeftMenuItemsAreDisplayed();
        Assert.assertEquals(leftMenu.transferListOfLeftMenuItems(), expectedNamesOfLeftMenuItems);
    }
}
