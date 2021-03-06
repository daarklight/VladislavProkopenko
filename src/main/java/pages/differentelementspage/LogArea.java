package pages.differentelementspage;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogArea {

    @FindBy(css = "ul.panel-body-list.logs > li")
    private List<WebElement> logTextsWebElements;

    public List<String> transferListOfLogRowsTexts() {
        return logTextsWebElements.stream().map(
            elem -> elem.getText().substring(9)).collect(Collectors.toList());
    }
}
