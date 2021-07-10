package pages.hw4.mainpage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw4.AbstractPageHW4;

public class LeftMenuHW4 extends AbstractPageHW4 {

    public LeftMenuHW4(WebDriver webdriver) {
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
