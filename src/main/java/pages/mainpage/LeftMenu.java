package pages.mainpage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LeftMenu {

    @FindAll({@FindBy(
            css = "div[name='navigation-sidebar'] ul.sidebar-menu.left a[href = 'index.html'] > span:nth-child(1)"),
                 @FindBy(css = "div[name='navigation-sidebar'] ul.sidebar-menu.left a[href = 'contacts.html']"),
                 @FindBy(css = "div[name='navigation-sidebar'] ul.sidebar-menu.left li[index = '3'] > a[ui='label']"),
                 @FindBy(css = "div[name='navigation-sidebar'] ul.sidebar-menu.left a[href = 'metals-colors.html']"),
                 @FindBy(css = "div[name='navigation-sidebar'] ul.sidebar-menu.left "
                         + "li.menu-title:nth-child(5) a[ui='label']"
                 )})
    public List<WebElement> cssSelectorsForLeftSectionMenu;

    public boolean checkIfLeftMenuItemsAreDisplayed() {
        try {
            cssSelectorsForLeftSectionMenu.stream().forEach(elem -> elem.isDisplayed());
            return true;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public List<String> checkDisplayedLeftMenuItems() {
        List<String> listOfLeftMenuItemNames = cssSelectorsForLeftSectionMenu.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        return listOfLeftMenuItemNames;
    }

    public List<String> showExpectedListOfNamesForLeftMenuItems(String leftMenuItem1, String leftMenuItem2,
                                                                String leftMenuItem3, String leftMenuItem4,
                                                                String leftMenuItem5) {
        List<String> expectedListOfLeftMenuItemNames = Arrays.asList(
            leftMenuItem1, leftMenuItem2, leftMenuItem3, leftMenuItem4, leftMenuItem5);
        return expectedListOfLeftMenuItemNames;
    }
}
