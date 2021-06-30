package pages.mainpage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu {

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li")
    public List<WebElement> listOfHeaderItemsWebElements;

    public void checkIfHeaderItemsAreDisplayed() {
        listOfHeaderItemsWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new StaleElementReferenceException("Header menu items are not displayed");
            }
        });
    }

    public void checkNumberOfHeaderItems(int expectedNumberOfHeaderItems) {
        if (listOfHeaderItemsWebElements.size() != expectedNumberOfHeaderItems) {
            throw new StaleElementReferenceException("Number of header items is wrong");
        }
    }

    public void checkIfNamesOfHeaderMenuItemsAreAsExpected(String expectedNames) {
        List<String> listOfNamesForHeaderItems = listOfHeaderItemsWebElements.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        List<String> expectedListOfHeaderMenuItemsNames = Stream.of(expectedNames.split(" ; ")).map(
            elem -> new String(elem)).collect(Collectors.toList());
        if (!listOfNamesForHeaderItems.equals(expectedListOfHeaderMenuItemsNames)) {
            throw new StaleElementReferenceException(
                "Displayed and expected names of header menu items are not the same");
        }
    }

    @FindBy(css = "header ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle")
    public WebElement serviceWebElement;

    @FindBy(css = "header a[href = 'different-elements.html']")
    public WebElement differentElementsWebElement;

    public void clickDifferentElements() {
        serviceWebElement.click();
        differentElementsWebElement.click();
    }
}
