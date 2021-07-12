package ru.training.at.hw5.steps.exercise2steps;

import io.cucumber.java.en.Given;
import ru.training.at.hw5.steps.AbstractSteps;

public class GivenStep extends AbstractSteps {
    //    @Given("I open JDI GitHub site")
    //    public void openSite() {
    //        commonPageContent.openPage();
    //    }

    //    @Given("I login using proper username {string} and password {string}")
    //    public void performLogin(String username, String password) {
    //        loginFields.login(username, password);
    //    }

    @Given("I login as user {string}")
    public void checkIfUsernameIsLoggedIn(String user) {
        loginFields.checkIfUsernameIsLoggedIn(user);
    }
}
