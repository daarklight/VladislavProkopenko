package ru.training.at.hw5.steps.exercise2steps;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.steps.AbstractSteps;

public class WhenStep extends AbstractSteps {

    @Given("I click on \"Service\" button in Header")
    public void clickServiceButton() {
        headerMenu.clickService();
    }

    @Given("I click on \"User Table\" button in Service dropdown")
    public void clickUserTableButton() {
        headerMenu.clickUserTable();
    }
}
