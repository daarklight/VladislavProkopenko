package ru.training.at.hw5.steps.exercise1steps;

import io.cucumber.java.en.Then;
import java.util.List;
import org.testng.Assert;
import ru.training.at.hw5.steps.AbstractSteps;

public class ThenStep extends AbstractSteps {

    @Then("Displayed log rows are consistent with selected checkboxes, radiobutton and dropdown")
    public void assertThatLogsAreCorrect(List<String> expectedLogRowsTexts) {
        Assert.assertEquals(differentElementsLogArea.transferListOfLogRowsTexts(), expectedLogRowsTexts);
    }
}
