package pages.mainpage;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrame {
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
}
