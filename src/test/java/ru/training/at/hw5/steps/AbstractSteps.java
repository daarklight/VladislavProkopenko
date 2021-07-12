package ru.training.at.hw5.steps;

import pages.hw5.differentelementspage.ButtonsAndDropdownArea;
import pages.hw5.differentelementspage.DifferentElementsLogArea;
import pages.hw5.driver.WebDriverSingleton;
import pages.hw5.mainpage.BottomPicturesAndTexts;
import pages.hw5.mainpage.CommonPageContent;
import pages.hw5.mainpage.HeaderMenu;
import pages.hw5.mainpage.IFrame;
import pages.hw5.mainpage.LeftMenu;
import pages.hw5.mainpage.LoginFields;
import pages.hw5.usertable.UserTableLogArea;
import pages.hw5.usertable.UsersArea;

public class AbstractSteps {

    protected BottomPicturesAndTexts bottomPicturesAndTexts;
    protected CommonPageContent commonPageContent;
    protected HeaderMenu headerMenu;
    protected IFrame iframe;
    protected LeftMenu leftMenu;
    protected LoginFields loginFields;
    protected ButtonsAndDropdownArea buttonsAndDropdownArea;
    protected DifferentElementsLogArea differentElementsLogArea;
    protected UsersArea usersArea;
    protected UserTableLogArea userTableLogArea;

    protected AbstractSteps() {
        bottomPicturesAndTexts = new BottomPicturesAndTexts(WebDriverSingleton.getDriver());
        commonPageContent = new CommonPageContent(WebDriverSingleton.getDriver());
        headerMenu = new HeaderMenu(WebDriverSingleton.getDriver());
        iframe = new IFrame(WebDriverSingleton.getDriver());
        leftMenu = new LeftMenu(WebDriverSingleton.getDriver());
        loginFields = new LoginFields(WebDriverSingleton.getDriver());
        buttonsAndDropdownArea = new ButtonsAndDropdownArea(WebDriverSingleton.getDriver());
        differentElementsLogArea = new DifferentElementsLogArea(WebDriverSingleton.getDriver());
        usersArea = new UsersArea(WebDriverSingleton.getDriver());
        userTableLogArea = new UserTableLogArea(WebDriverSingleton.getDriver());
    }
}
