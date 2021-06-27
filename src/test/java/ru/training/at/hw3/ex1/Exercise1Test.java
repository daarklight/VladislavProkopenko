package ru.training.at.hw3.ex1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.mainpage.BottomPicturesAndTexts;
import pages.mainpage.HeaderMenu;
import pages.mainpage.IFrame;
import pages.mainpage.LeftMenu;
import pages.mainpage.LoginFields;
import ru.training.at.hw3.commonsteps.PrepostConditions;

public class Exercise1Test extends PrepostConditions {

    public static final int numberOfHeaderItems = 4;
    public static final int numberOfTextFieldsAndImages = 4;

    @Test
    public void exercise1Test() {

        SoftAssert softAssert = new SoftAssert();

        // 2. Assert Browser title
        softAssert.assertEquals(webdriver.getTitle(), properties.getProperty("titleForMainPage"));

        // 3. Perform login
        LoginFields loginFields = PageFactory.initElements(webdriver, LoginFields.class);
        loginFields.login(properties.getProperty("username"), properties.getProperty("password"));

        // 4. Assert Username is logged in
        softAssert.assertEquals(loginFields.getDisplayedUserName(), properties.getProperty("displayedUserName"));

        // 5. Assert that 4 items on the header section are displayed and have proper texts
        HeaderMenu headerMenu = PageFactory.initElements(webdriver, HeaderMenu.class);

        softAssert
            .assertEquals(headerMenu.checkDisplayedHeaderTexts(), headerMenu
                .showExpectedListOfNamesForHeaderItems(properties.getProperty("headerMenuItem1"),
                    properties.getProperty("headerMenuItem2"),
                    properties.getProperty("headerMenuItem3"), properties.getProperty("headerMenuItem4")));
        softAssert.assertTrue(headerMenu.checkIfHeaderItemsAreDisplayed());
        softAssert.assertEquals(headerMenu.checkNumberOfHeaderItems(), numberOfHeaderItems);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        BottomPicturesAndTexts bottomPicturesAndTexts =
            PageFactory.initElements(webdriver, BottomPicturesAndTexts.class);
        softAssert.assertEquals(bottomPicturesAndTexts.checkNumberOfImages(), numberOfTextFieldsAndImages);
        softAssert.assertTrue(bottomPicturesAndTexts.checkIfAllImagesAreDisplayed());

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // (According to teacher's recommendations, it was decided to exclude the requirement of
        // searching these 4 texts under the icons. So, each text is searched as is, without
        // any connections to points in space)
        softAssert.assertEquals(bottomPicturesAndTexts.checkNumberOfBenefitTexts(), numberOfTextFieldsAndImages);
        softAssert.assertEquals(bottomPicturesAndTexts.checkDisplayedBenefitTexts(),
            bottomPicturesAndTexts.showExpectedListOfNamesForHeaderItems(properties.getProperty("benefitText1"),
                properties.getProperty("benefitText2"),
                properties.getProperty("benefitText3"), properties.getProperty("benefitText4")));

        // 8. Assert that the iframe with “Frame Button” exists
        // (Cause step #9 checks whether “Frame Button” exists in the iframe,
        // it was decided to check only existence of the frame)
        IFrame iframe = PageFactory.initElements(webdriver, IFrame.class);
        softAssert.assertTrue(iframe.checkIfIframeIsDisplayed());

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webdriver.switchTo().frame(properties.getProperty("iFrameName"));
        softAssert.assertTrue(iframe.checkFrameButton());

        // 10. Switch to original window back
        webdriver.switchTo().defaultContent();

        // 11. Assert that 5 items in the Left Section are displayed and have proper text
        LeftMenu leftMenu = PageFactory.initElements(webdriver, LeftMenu.class);
        softAssert.assertTrue(leftMenu.checkIfLeftMenuItemsAreDisplayed());
        softAssert
            .assertEquals(leftMenu.checkDisplayedLeftMenuItems(), leftMenu.showExpectedListOfNamesForLeftMenuItems(
                properties.getProperty("leftMenuItem1"), properties.getProperty("leftMenuItem2"),
                properties.getProperty("leftMenuItem3"), properties.getProperty("leftMenuItem4"),
                properties.getProperty("leftMenuItem5")));

        softAssert.assertAll();
    }
}
