package pages.hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPageHW4 {

    protected WebDriver webdriver;

    protected AbstractPageHW4(WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver, this);
    }

}
