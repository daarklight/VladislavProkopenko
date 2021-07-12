package pages.hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected static final String mainPageURL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected WebDriver webdriver;
    protected WebDriverWait wait;

    protected AbstractPage(WebDriver webdriver) {
        this.webdriver = webdriver;
        wait = new WebDriverWait(webdriver, 10L);
        PageFactory.initElements(webdriver, this);
    }

}
