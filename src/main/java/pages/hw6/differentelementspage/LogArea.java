package pages.hw6.differentelementspage;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw6.AbstractPage;

public class LogArea extends AbstractPage {

    public LogArea(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(css = "ul.panel-body-list.logs > li")
    private List<WebElement> logTextsWebElements;

    public List<String> transferListOfLogRowsTexts() {
        return logTextsWebElements.stream().map(
            elem -> elem.getText().substring(9)).collect(Collectors.toList());
    }
}
