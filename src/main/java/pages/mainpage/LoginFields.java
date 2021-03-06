package pages.mainpage;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFields {

    @FindBy(css = "li.dropdown.uui-profile-menu > a.dropdown-toggle")
    private WebElement arrowButtonToAppearLoginForm;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "span#user-name")
    private WebElement nameFieldOfLoggedUser;

    public void login(String username, String password) {
        arrowButtonToAppearLoginForm.click();
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkIfUsernameIsLoggedIn(String displayedUsername) {
        if (!nameFieldOfLoggedUser.getText().equals(displayedUsername)) {
            throw new NoSuchElementException("Displayed username is wrong");
        }
    }
}
