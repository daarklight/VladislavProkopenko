package ru.training.at.hw3.ex1;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mainpage.BottomPicturesAndTexts;
import pages.mainpage.HeaderMenu;
import pages.mainpage.IFrame;
import pages.mainpage.LeftMenu;
import pages.mainpage.LoginFields;
import ru.training.at.hw3.commonsteps.PrepostConditions;
import ru.training.at.hw3.resources.DataProviders;

public class Exercise1Test extends PrepostConditions {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "Names of Header Menu Items")
    public void testExercise1TestStepsFrom1To6(String expectedNamesOfHeaderMenuItems) {
        // 2. Assert Browser title
        Assert.assertEquals(webdriver.getTitle(), properties.getProperty("titleForMainPage"));

        // 3. Perform login
        LoginFields loginFields = PageFactory.initElements(webdriver, LoginFields.class);
        loginFields.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is logged in
        loginFields.checkIfUsernameIsLoggedIn(properties.getProperty("displayedUsername"));

        // 5. Assert that 4 items on the header section are displayed and have proper texts
        HeaderMenu headerMenu = PageFactory.initElements(webdriver, HeaderMenu.class);
        headerMenu.checkIfNamesOfHeaderMenuItemsAreAsExpected(expectedNamesOfHeaderMenuItems);
        headerMenu.checkIfHeaderItemsAreDisplayed();
        headerMenu.checkNumberOfHeaderItems(Integer.parseInt(properties.getProperty("expectedNumberOfHeaderItems")));

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        BottomPicturesAndTexts bottomPicturesAndTexts =
            PageFactory.initElements(webdriver, BottomPicturesAndTexts.class);


        bottomPicturesAndTexts.checkNumberOfImages(
            Integer.parseInt(properties.getProperty("expectedNumberOfTextFieldsAndImages")));
        bottomPicturesAndTexts.checkIfAllImagesAreDisplayed();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "Benefit Texts")
    public void testExercise1TestStepsFrom7To10(String expectedBenefitTexts) {
        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // (According to teacher's recommendations, it was decided to exclude the requirement of
        // searching these 4 texts under the icons. So, each text is searched as is, without
        // any connections to points in space)
        BottomPicturesAndTexts bottomPicturesAndTexts =
            PageFactory.initElements(webdriver, BottomPicturesAndTexts.class);
        bottomPicturesAndTexts.checkNumberOfBenefitTexts(
            Integer.parseInt(properties.getProperty("expectedNumberOfTextFieldsAndImages")));
        bottomPicturesAndTexts.checkIfBenefitTextsAreAsExpected(expectedBenefitTexts);

        // 8. Assert that the iframe with “Frame Button” exists
        // (Cause step #9 checks whether “Frame Button” exists in the iframe,
        // it was decided to check only existence of the frame)
        IFrame iframe = PageFactory.initElements(webdriver, IFrame.class);
        iframe.checkIfIframeExists();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webdriver.switchTo().frame(properties.getProperty("iframeName"));
        iframe.checkIfIframeButtonExists();

        // 10. Switch to original window back
        webdriver.switchTo().defaultContent();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "Names of Left Menu Items")
    public void testExercise1TestStep11(String expectedNamesOfLeftMenuItems) {
        // 11. Assert that 5 items in the Left Section are displayed and have proper text
        LeftMenu leftMenu = PageFactory.initElements(webdriver, LeftMenu.class);
        leftMenu.checkIfLeftMenuItemsAreDisplayed();
        leftMenu.checkIfNamesOfLeftMenuItemsAreAsExpected(expectedNamesOfLeftMenuItems);
    }
}
