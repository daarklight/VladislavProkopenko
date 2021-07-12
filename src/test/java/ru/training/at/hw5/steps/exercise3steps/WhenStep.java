package ru.training.at.hw5.steps.exercise3steps;

import io.cucumber.java.en.When;
import ru.training.at.hw5.steps.AbstractSteps;

public class WhenStep extends AbstractSteps {

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void clickVipCheckboxForSergeyIvan() {
        usersArea.clickSergeyIvanVipCheckbox();
    }
}
