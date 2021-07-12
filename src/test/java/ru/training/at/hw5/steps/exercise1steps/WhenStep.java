package ru.training.at.hw5.steps.exercise1steps;

import io.cucumber.java.en.When;
import ru.training.at.hw5.steps.AbstractSteps;

public class WhenStep extends AbstractSteps {

    @When("I select Water and Wind checkboxes")
    public void selectCheckboxes() {
        buttonsAndDropdownArea.clickCheckBoxes();
    }

    @When("I select Selen radiobutton")
    public void selectRadioButton() {
        buttonsAndDropdownArea.clickRadioButton();
    }

    @When("I select {string} from dropdown")
    public void selectInDropdown(String dropdownColor) {
        buttonsAndDropdownArea.selectDropdown(dropdownColor);
    }

}
