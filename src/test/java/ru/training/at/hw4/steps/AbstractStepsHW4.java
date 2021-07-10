package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import pages.hw4.differentelementspage.ButtonsAndDropdownAreaHW44;
import pages.hw4.differentelementspage.LogAreaHW44;
import pages.hw4.mainpage.BottomPicturesAndTextsHW44;
import pages.hw4.mainpage.CommonPageContentHW44;
import pages.hw4.mainpage.HeaderMenuHW44;
import pages.hw4.mainpage.IFrameHW44;
import pages.hw4.mainpage.LeftMenuHW44;
import pages.hw4.mainpage.LoginFieldsHW44;

public class AbstractStepsHW4 {

    BottomPicturesAndTextsHW44 bottomPicturesAndTexts;
    CommonPageContentHW44 commonPageContent;
    HeaderMenuHW44 headerMenu;
    IFrameHW44 iframe;
    LeftMenuHW44 leftMenu;
    LoginFieldsHW44 loginFields;
    ButtonsAndDropdownAreaHW44 buttonsAndDropdownArea;
    LogAreaHW44 logArea;

    protected AbstractStepsHW4(WebDriver webdriver) {
        bottomPicturesAndTexts = new BottomPicturesAndTextsHW44(webdriver);
        commonPageContent = new CommonPageContentHW44(webdriver);
        headerMenu = new HeaderMenuHW44(webdriver);
        iframe = new IFrameHW44(webdriver);
        leftMenu = new LeftMenuHW44(webdriver);
        loginFields = new LoginFieldsHW44(webdriver);
        buttonsAndDropdownArea = new ButtonsAndDropdownAreaHW44(webdriver);
        logArea = new LogAreaHW44(webdriver);
    }
}
