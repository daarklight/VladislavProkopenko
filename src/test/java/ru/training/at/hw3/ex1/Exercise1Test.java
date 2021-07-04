package ru.training.at.hw3.ex1;

import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mainpage.BottomPicturesAndTexts;
import pages.mainpage.HeaderMenu;
import pages.mainpage.IFrame;
import pages.mainpage.LeftMenu;
import pages.mainpage.LoginFields;
import ru.training.at.hw3.commonsteps.PrepostConditions;
import ru.training.at.hw3.resources.DataProvidersForExercise1Test;

public class Exercise1Test extends PrepostConditions {

    @Test(dataProviderClass = DataProvidersForExercise1Test.class, dataProvider = "Data for Exercise1Test")
    public void testExercise1Test(
        String mainPageURL, String titleForMainPage, String username, String password,
        String displayedUsername, List<String> expectedNamesOfHeaderMenuItems,
        int expectedNumberOfTextFieldsAndImages, List<String> expectedBenefitTexts,
        String iframeName, List<String> expectedNamesOfLeftMenuItems) {

        // 1. Open test site by URL
        webdriver.navigate().to(mainPageURL);

        // 2. Assert Browser title
        Assert.assertEquals(webdriver.getTitle(), titleForMainPage);

        // 3. Perform login
        LoginFields loginFields = PageFactory.initElements(webdriver, LoginFields.class);
        loginFields.login(username, password);

        // 4. Assert Username is logged in
        loginFields.checkIfUsernameIsLoggedIn(displayedUsername);

        // 5. Assert that 4 items on the header section are displayed and have proper texts
        HeaderMenu headerMenu = PageFactory.initElements(webdriver, HeaderMenu.class);
        headerMenu.checkIfHeaderItemsAreDisplayed();
        Assert.assertEquals(headerMenu.transferListOfHeaderMenuItems(), expectedNamesOfHeaderMenuItems);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        BottomPicturesAndTexts bottomPicturesAndTexts =
            PageFactory.initElements(webdriver, BottomPicturesAndTexts.class);
        bottomPicturesAndTexts.checkNumberOfImages(expectedNumberOfTextFieldsAndImages);
        bottomPicturesAndTexts.checkIfAllImagesAreDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // (According to teacher's recommendations, it was decided to exclude the requirement of
        // searching these 4 texts under the icons. So, each text is searched as is, without
        // any connections to points in space)
        Assert.assertEquals(bottomPicturesAndTexts.transferListOfBenefitTexts(),
            expectedBenefitTexts);

        // 8. Assert that the iframe with “Frame Button” exists
        // (Cause step #9 checks whether “Frame Button” exists in the iframe,
        // it was decided to check only existence of the frame)
        IFrame iframe = PageFactory.initElements(webdriver, IFrame.class);
        iframe.checkIfIframeExists();

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webdriver.switchTo().frame(iframeName);
        iframe.checkIfIframeButtonExists();

        // 10. Switch to original window back
        webdriver.switchTo().defaultContent();

        // 11. Assert that 5 items in the Left Section are displayed and have proper text
        LeftMenu leftMenu = PageFactory.initElements(webdriver, LeftMenu.class);
        leftMenu.checkIfLeftMenuItemsAreDisplayed();
        Assert.assertEquals(leftMenu.transferListOfLeftMenuItems(), expectedNamesOfLeftMenuItems);
    }
}
