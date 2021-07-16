package ru.training.at.hw6.steps;

import org.openqa.selenium.WebDriver;
import pages.hw6.differentelementspage.ButtonsAndDropdownArea;
import pages.hw6.differentelementspage.LogArea;
import pages.hw6.mainpage.BottomPicturesAndTexts;
import pages.hw6.mainpage.CommonPageContent;
import pages.hw6.mainpage.HeaderMenu;
import pages.hw6.mainpage.IFrame;
import pages.hw6.mainpage.LeftMenu;
import pages.hw6.mainpage.LoginFields;

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
