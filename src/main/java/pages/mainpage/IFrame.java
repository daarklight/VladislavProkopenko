package pages.mainpage;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrame {
    @FindBy(tagName = "iframe")
    public WebElement iframeWebElement;

    public void checkIfIframeExists() {
        if (!iframeWebElement.isDisplayed()) {
            throw new StaleElementReferenceException("iframe does not exist");
        }
    }

    @FindBy(xpath = "//input[@type='button'] [contains(@value, 'Frame Button')]")
    public WebElement frameButtonWebElement;

    public void checkIfIframeButtonExists() {
        if (!frameButtonWebElement.isDisplayed()) {
            throw new StaleElementReferenceException("iframe button does not exist in the iframe");
        }
    }
}
