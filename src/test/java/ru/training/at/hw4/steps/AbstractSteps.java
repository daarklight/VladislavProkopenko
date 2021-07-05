package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import pages.hw4.differentelementspage.ButtonsAndDropdownArea;
import pages.hw4.differentelementspage.LogArea;
import pages.hw4.mainpage.BottomPicturesAndTexts;
import pages.hw4.mainpage.CommonPageContent;
import pages.hw4.mainpage.HeaderMenu;
import pages.hw4.mainpage.IFrame;
import pages.hw4.mainpage.LeftMenu;
import pages.hw4.mainpage.LoginFields;

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
