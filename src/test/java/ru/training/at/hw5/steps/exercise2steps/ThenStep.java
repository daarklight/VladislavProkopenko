package ru.training.at.hw5.steps.exercise2steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.List;
import org.testng.Assert;
import ru.training.at.hw5.steps.AbstractSteps;

public class ThenStep extends AbstractSteps {

    @Then("{string} page should be opened")
    public void assertThatPageTitleIsCorrect(String pageName) {
        Assert.assertEquals(usersArea.getPageTitle(), pageName);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertThatNumberOfNumberTypeDropdownsIsCorrectAndCheckIfTheyAreDisplayed(
        int expectedNumberOfNumberTypeDropdowns) {
        Assert.assertEquals(usersArea.countNumberOfNumberTypeDropdownsAndCheckIfTheyAreDisplayed(),
            expectedNumberOfNumberTypeDropdowns);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertThatNumberOfUsernamesIsCorrectAndCheckIfTheyAreDisplayed(
        int expectedNumberOfUsernames) {
        Assert.assertEquals(usersArea.countNumberOfUsernamesAndCheckIfTheyAreDisplayed(),
            expectedNumberOfUsernames);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void assertThatNumberOfDescriptionTextsIsCorrectAndCheckIfTheyAreDisplayed(
        int expectedNumberOfDescriptionTexts) {
        Assert.assertEquals(usersArea.countNumberOfDescriptionTextsAndCheckIfTheyAreDisplayed(),
            expectedNumberOfDescriptionTexts);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertThatNumberOfCheckboxesIsCorrectAndCheckIfTheyAreDisplayed(
        int expectedNumberOfCheckboxes) {
        Assert.assertEquals(usersArea.countNumberOfCheckboxesAndCheckIfTheyAreDisplayed(),
            expectedNumberOfCheckboxes);
    }

    @Then("User table should contain following values:")
    public void checkIfUserTableContainsProperValues(DataTable dataTable) {
        List<List<String>> userInfoList = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(usersArea.transferListOfListWithUserData().get(i), userInfoList.get(i).subList(1, 7));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkIfDropdownValuesAreAsExpected(List<String> expectedDropdownValues) {
        Assert.assertEquals(usersArea.transferListOfDropdownValues(), expectedDropdownValues.subList(1, 4));
    }
}
