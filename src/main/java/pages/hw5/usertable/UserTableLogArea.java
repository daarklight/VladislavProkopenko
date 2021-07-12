package pages.hw5.usertable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw5.AbstractPage;

public class UserTableLogArea extends AbstractPage {

    public UserTableLogArea(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(css = "ul.panel-body-list.logs > li")
    private WebElement logTextWebElement;

    public String transferLogRowText() {
        return logTextWebElement.getText().substring(9);
    }

}
