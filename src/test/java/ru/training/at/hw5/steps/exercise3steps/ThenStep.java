package ru.training.at.hw5.steps.exercise3steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import ru.training.at.hw5.steps.AbstractSteps;

public class ThenStep extends AbstractSteps {

    @Then("I log row has {string} text in log section")
    public void assertThatLogRowIsCorrect(String expectedLogRow) {
        Assert.assertEquals(userTableLogArea.transferLogRowText(), expectedLogRow);
    }
}
