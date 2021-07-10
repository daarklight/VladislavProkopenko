package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import pages.hw4.differentelementspage.ButtonsAndDropdownAreaHW4;
import pages.hw4.differentelementspage.LogAreaHW4;
import pages.hw4.mainpage.BottomPicturesAndTextsHW4;
import pages.hw4.mainpage.CommonPageContentHW4;
import pages.hw4.mainpage.HeaderMenuHW4;
import pages.hw4.mainpage.IFrameHW4;
import pages.hw4.mainpage.LeftMenuHW4;
import pages.hw4.mainpage.LoginFieldsHW4;

public class AbstractStepsHW4 {

    BottomPicturesAndTextsHW4 bottomPicturesAndTexts;
    CommonPageContentHW4 commonPageContent;
    HeaderMenuHW4 headerMenu;
    IFrameHW4 iframe;
    LeftMenuHW4 leftMenu;
    LoginFieldsHW4 loginFields;
    ButtonsAndDropdownAreaHW4 buttonsAndDropdownArea;
    LogAreaHW4 logArea;

    protected AbstractStepsHW4(WebDriver webdriver) {
        bottomPicturesAndTexts = new BottomPicturesAndTextsHW4(webdriver);
        commonPageContent = new CommonPageContentHW4(webdriver);
        headerMenu = new HeaderMenuHW4(webdriver);
        iframe = new IFrameHW4(webdriver);
        leftMenu = new LeftMenuHW4(webdriver);
        loginFields = new LoginFieldsHW4(webdriver);
        buttonsAndDropdownArea = new ButtonsAndDropdownAreaHW4(webdriver);
        logArea = new LogAreaHW4(webdriver);
    }
}
