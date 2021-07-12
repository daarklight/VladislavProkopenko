package pages.hw5.differentelementspage;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw5.AbstractPage;

public class DifferentElementsLogArea extends AbstractPage {

    public DifferentElementsLogArea(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(css = "ul.panel-body-list.logs > li")
    private List<WebElement> logTextsWebElements;

    public List<String> transferListOfLogRowsTexts() {
        return logTextsWebElements.stream().map(
            elem -> elem.getText().substring(9)).collect(Collectors.toList());
    }
}
