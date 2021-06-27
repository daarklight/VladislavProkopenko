package pages.mainpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrame {
    @FindBy(tagName = "iframe")
    public WebElement iframeWebElement;

    public boolean checkIfIframeIsDisplayed() {
        return iframeWebElement.isDisplayed();
    }

    @FindBy(xpath = "//input[@type='button'] [contains(@value, 'Frame Button')]")
    public WebElement frameButtonWebElement;

    public boolean checkFrameButton() {
        return frameButtonWebElement.isDisplayed();
    }

}
