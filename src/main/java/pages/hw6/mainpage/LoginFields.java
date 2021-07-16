package pages.hw6.mainpage;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw6.AbstractPage;

public class LoginFields extends AbstractPage {

    public LoginFields(WebDriver webdriver) {
        super(webdriver);
    }

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
