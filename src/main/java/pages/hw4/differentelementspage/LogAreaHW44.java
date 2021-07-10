package pages.hw4.differentelementspage;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw4.AbstractPageHW4;

public class LogAreaHW44 extends AbstractPageHW4 {

    public LogAreaHW44(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(css = "ul.panel-body-list.logs > li")
    private List<WebElement> logTextsWebElements;

    public List<String> transferListOfLogRowsTexts() {
        return logTextsWebElements.stream().map(
            elem -> elem.getText().substring(9)).collect(Collectors.toList());
    }
}
