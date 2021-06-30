package pages.differentelementspage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogArea {

    @FindBy(css = "ul.panel-body-list.logs > li")
    public List<WebElement> logTextsWebElements;

    public void checkIfLogRowsExistForAllButtonsAndDropdown(String expectedTexts) {
        List<String> listOfLogRowsTexts = logTextsWebElements.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        List<String> expectedListOfLogRowsTexts = Stream.of(expectedTexts.split(" ; ")).map(
            elem -> new String(elem)).collect(Collectors.toList());
        for (int i = 0; i < listOfLogRowsTexts.size(); i++) {
            if (!listOfLogRowsTexts.get(i).contains(expectedListOfLogRowsTexts.get(i))) {
                throw new StaleElementReferenceException(
                    "Log rows are not in line with names of buttons and or dropdown");
            }
        }
    }
}
