package pages.mainpage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu {
    @FindBy(css = "ul.sidebar-menu.left > li")
    public List<WebElement> cssSelectorsForLeftSectionMenu;

    public void checkIfLeftMenuItemsAreDisplayed() {
        cssSelectorsForLeftSectionMenu.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Left menu items are not displayed");
            }
        });
    }

    public List<String> transferListOfLeftMenuItems() {
        List<String> listOfLeftMenuItemNames = cssSelectorsForLeftSectionMenu.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        return listOfLeftMenuItemNames;
    }
}
