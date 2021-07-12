package ru.training.at.hw5.steps.exercise1steps;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.steps.AbstractSteps;

public class GivenStep extends AbstractSteps {

    @Given("I open JDI GitHub site")
    public void openSite() {
        commonPageContent.openPage();
    }

    @Given("I login using proper username {string} and password {string}")
    public void performLogin(String username, String password) {
        loginFields.login(username, password);
    }

    @Given("I open Different Elements Page")
    public void openDifferentElementsPage() {
        headerMenu.clickDifferentElements();
    }
}
