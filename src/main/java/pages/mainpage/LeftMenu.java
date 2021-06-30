package pages.mainpage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenu {
    @FindBy(css = "ul.sidebar-menu.left > li")
    public List<WebElement> cssSelectorsForLeftSectionMenu;

    public void checkIfLeftMenuItemsAreDisplayed() {
        cssSelectorsForLeftSectionMenu.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new StaleElementReferenceException("Left menu items are not displayed");
            }
        });
    }

    public void checkIfNamesOfLeftMenuItemsAreAsExpected(String expectedNames) {
        List<String> listOfLeftMenuItemNames = cssSelectorsForLeftSectionMenu.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        List<String> expectedListOfLeftMenuItemNames = Stream.of(expectedNames.split(" ; ")).map(
            elem -> new String(elem)).collect(Collectors.toList());
        if (!listOfLeftMenuItemNames.equals(expectedListOfLeftMenuItemNames)) {
            throw new StaleElementReferenceException(
                "Displayed and expected names of left menu items are not the same");
        }
    }
}
