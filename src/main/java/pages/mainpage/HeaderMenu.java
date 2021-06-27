package pages.mainpage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu {

    @FindAll({@FindBy(css = "header a[href = 'index.html']"),
                 @FindBy(css = "header a[href = 'contacts.html']"),
                 @FindBy(css = "header ul.uui-navigation.nav.navbar-nav.m-l8 a.dropdown-toggle"),
                 @FindBy(css = "header a[href = 'metals-colors.html']")})
    public List<WebElement> listOfHeaderItemsWebElements;

    public boolean checkIfHeaderItemsAreDisplayed() {
        try {
            listOfHeaderItemsWebElements.stream().forEach(elem -> elem.isDisplayed());
            return true;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public int checkNumberOfHeaderItems() {
        return listOfHeaderItemsWebElements.size();
    }

    public List<String> checkDisplayedHeaderTexts() {
        List<String> listOfNamesForHeaderItems = listOfHeaderItemsWebElements.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        return listOfNamesForHeaderItems;
    }

    public List<String> showExpectedListOfNamesForHeaderItems(String headerMenuItem1, String headerMenuItem2,
                                                              String headerMenuItem3, String headerMenuItem4) {
        List<String> expectedListOfNamesForHeaderItems = Arrays.asList(
            headerMenuItem1, headerMenuItem2, headerMenuItem3, headerMenuItem4);
        return expectedListOfNamesForHeaderItems;
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
