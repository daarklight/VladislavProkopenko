package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import pages.differentelementspage.ButtonsAndDropdownArea;
import pages.differentelementspage.LogArea;
import pages.mainpage.BottomPicturesAndTexts;
import pages.mainpage.CommonPageContent;
import pages.mainpage.HeaderMenu;
import pages.mainpage.IFrame;
import pages.mainpage.LeftMenu;
import pages.mainpage.LoginFields;

public class AbstractSteps {

    BottomPicturesAndTexts bottomPicturesAndTexts;
    CommonPageContent commonPageContent;
    HeaderMenu headerMenu;
    IFrame iframe;
    LeftMenu leftMenu;
    LoginFields loginFields;
    ButtonsAndDropdownArea buttonsAndDropdownArea;
    LogArea logArea;

    protected AbstractSteps(WebDriver webdriver) {
        bottomPicturesAndTexts = new BottomPicturesAndTexts(webdriver);
        commonPageContent = new CommonPageContent(webdriver);
        headerMenu = new HeaderMenu(webdriver);
        iframe = new IFrame(webdriver);
        leftMenu = new LeftMenu(webdriver);
        loginFields = new LoginFields(webdriver);
        buttonsAndDropdownArea = new ButtonsAndDropdownArea(webdriver);
        logArea = new LogArea(webdriver);
    }
}
