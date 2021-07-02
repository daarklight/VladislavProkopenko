package pages.mainpage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu {

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> listOfHeaderItemsWebElements;

    @FindBy(css = "header ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle")
    private WebElement serviceWebElement;

    @FindBy(css = "header a[href = 'different-elements.html']")
    private WebElement differentElementsWebElement;


    public void checkIfHeaderItemsAreDisplayed() {
        listOfHeaderItemsWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Header menu items are not displayed");
            }
        });
    }

    public List<String> transferListOfHeaderMenuItems() {
        return listOfHeaderItemsWebElements.stream().map(elem -> elem.getText()).collect(Collectors.toList());
    }

    public void clickDifferentElements() {
        serviceWebElement.click();
        differentElementsWebElement.click();
    }
}
