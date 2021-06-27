package pages.mainpage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class BottomPicturesAndTexts {

    @FindAll({@FindBy(css = "span.icons-benefit.icon-practise"),
                 @FindBy(css = "span.icons-benefit.icon-custom"),
                 @FindBy(css = "span.icons-benefit.icon-multi"),
                 @FindBy(css = "span.icons-benefit.icon-base")})
    public List<WebElement> cssSelectorsForImages;

    @FindAll({@FindBy(className = "benefit-icon")})
    public List<WebElement> benefitImagesWebElements;

    public int checkNumberOfImages() {
        return benefitImagesWebElements.size();
    }

    public boolean checkIfAllImagesAreDisplayed() {
        try {
            cssSelectorsForImages.stream().forEach(elem -> elem.isDisplayed());
            return true;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    @FindAll({@FindBy(className = "benefit-txt")})
    public List<WebElement> benefitTextsWebElements;

    public int checkNumberOfBenefitTexts() {
        return benefitTextsWebElements.size();
    }

    public List<String> checkDisplayedBenefitTexts() {
        List<String> listOfUnderIconsTextFields = benefitTextsWebElements.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        return listOfUnderIconsTextFields;
    }

    public List<String> showExpectedListOfNamesForHeaderItems(String benefitText1, String benefitText2,
                                                              String benefitText3, String benefitText4) {
        List<String> expectedListOfUnderIconsTextFields = Arrays.asList(
            benefitText1,
            benefitText2,
            benefitText3,
            benefitText4);
        return expectedListOfUnderIconsTextFields;
    }
}
