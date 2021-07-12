package pages.hw5.mainpage;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw5.AbstractPage;

public class IFrame extends AbstractPage {

    public IFrame(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(tagName = "iframe")
    private WebElement iframeWebElement;

    @FindBy(xpath = "//input[@type='button'] [contains(@value, 'Frame Button')]")
    private WebElement frameButtonWebElement;

    public void checkIfIframeExists() {
        if (!iframeWebElement.isDisplayed()) {
            throw new NoSuchElementException("iframe does not exist");
        }
    }

    public void checkIfIframeButtonExists() {
        if (!frameButtonWebElement.isDisplayed()) {
            throw new NoSuchElementException("iframe button does not exist in the iframe");
        }
    }

    public void switchToIframe(String iframe) {
        webdriver.switchTo().frame(iframe);
    }
}
