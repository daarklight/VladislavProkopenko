package pages.differentelementspage;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LogArea {

    @FindAll(
        {@FindBy(xpath = "//div[@class = 'info-panel-section']//child::li[contains(text(), 'value changed to') "
            + "and contains(text(), 'Selen')]")})
    public List<WebElement> selenLog;

    @FindAll(
        {@FindBy(xpath =
                     "//div[@class = 'info-panel-section']//child::li[contains(text(), 'Water') "
                         + "and contains(text(), 'true')]")})
    public List<WebElement> waterLog;

    @FindAll(
        {@FindBy(xpath = "//div[@class = 'info-panel-section']//child::li[contains(text(), 'Wind') "
            + "and contains(text(), 'true')]")
        })
    public List<WebElement> windLog;

    @FindAll(
        {@FindBy(xpath = "//div[@class = 'info-panel-section']//child::li[contains(text(), 'value changed to Yellow')]")
        })
    public List<WebElement> yellowLog;

    public boolean checkIfLogRowsAreUniqueForButtonsAndDropdown() {
        if (selenLog.size() == 1 && waterLog.size() == 1 && windLog.size() == 1 && yellowLog.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
}
