package pages.hw5.usertable;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw5.AbstractPage;

public class UsersArea extends AbstractPage {

    public UsersArea(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(css = "input#ivan[type='checkbox']")
    private WebElement sergeyIvanVipCheckboxWebElement;

    @FindBy(css = "table#user-table select")
    private List<WebElement> listOfDropdownWebElements;

    @FindBy(css = "table#user-table a")
    private List<WebElement> listOfUsernamesWebElements;

    @FindBy(css = "table#user-table span")
    private List<WebElement> listOfDescriptionTextsWebElements;

    @FindBy(css = "table#user-table input[type='checkbox']")
    private List<WebElement> listOfCheckboxesWebElements;

    @FindBy(css = "table#user-table tr > td:first-child")
    private List<WebElement> listOfUserNumbersWebElements;

    @FindBy(css = "table#user-table tr:first-child > td + td > select > option")
    private List<WebElement> listOfDropdownValuesWebElements;

    public void clickSergeyIvanVipCheckbox() {
        sergeyIvanVipCheckboxWebElement.click();
    }

    public String getPageTitle() {
        return webdriver.getTitle();
    }

    public int countNumberOfNumberTypeDropdownsAndCheckIfTheyAreDisplayed() {
        listOfDropdownWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Number Type Dropdowns are not displayed");
            }
        });
        return listOfDropdownWebElements.size();
    }

    public int countNumberOfUsernamesAndCheckIfTheyAreDisplayed() {
        listOfUsernamesWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Usernames are not displayed");
            }
        });
        return listOfUsernamesWebElements.size();
    }

    public int countNumberOfDescriptionTextsAndCheckIfTheyAreDisplayed() {
        listOfDescriptionTextsWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Desciption texts are not displayed");
            }
        });
        return listOfDescriptionTextsWebElements.size();
    }

    public int countNumberOfCheckboxesAndCheckIfTheyAreDisplayed() {
        listOfCheckboxesWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Checkboxes are not displayed");
            }
        });
        return listOfCheckboxesWebElements.size();
    }

    public List<List<String>> transferListOfListWithUserData() {
        List<String> listOfUserNumbers = listOfUserNumbersWebElements.stream().map(elem ->
            elem.getText()).collect(Collectors.toList());
        List<String> listOfUsernames = listOfUsernamesWebElements.stream().map(elem ->
            elem.getText()).collect(Collectors.toList());
        List<String> listOfDescriptionTexts = listOfDescriptionTextsWebElements.stream().map(elem ->
            elem.getText()).collect(Collectors.toList());
        return Arrays.asList(listOfUserNumbers, listOfUsernames, listOfDescriptionTexts);
    }

    public List<String> transferListOfDropdownValues() {
        return listOfDropdownValuesWebElements.stream().map(elem ->
            elem.getText()).collect(Collectors.toList());
    }
}
