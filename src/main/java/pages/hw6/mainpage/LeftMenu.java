package pages.hw6.mainpage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw6.AbstractPage;

public class LeftMenu extends AbstractPage {

    public LeftMenu(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(css = "ul.sidebar-menu.left > li")
    private List<WebElement> cssSelectorsForLeftSectionMenu;

    public void checkIfLeftMenuItemsAreDisplayed() {
        cssSelectorsForLeftSectionMenu.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Left menu items are not displayed");
            }
        });
    }

    public List<String> transferListOfLeftMenuItems() {
        return cssSelectorsForLeftSectionMenu.stream().map(elem -> elem.getText()).collect(Collectors.toList());
    }
}
