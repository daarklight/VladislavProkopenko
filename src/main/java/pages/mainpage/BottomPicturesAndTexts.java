package pages.mainpage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BottomPicturesAndTexts {

    @FindBy(css = "div.benefit > div.benefit-icon")
    public List<WebElement> benefitImagesWebElements;

    public void checkNumberOfImages(int requiredNumberOfImages) {
        if (benefitImagesWebElements.size() != requiredNumberOfImages) {
            throw new StaleElementReferenceException("Number of benefit images is wrong");
        }
    }

    public void checkIfAllImagesAreDisplayed() {
        benefitImagesWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new StaleElementReferenceException("Benefit images are not displayed");
            }
        });
    }

    @FindBy(css = "div.benefit > span.benefit-txt")
    public List<WebElement> benefitTextsWebElements;

    public void checkNumberOfBenefitTexts(int requiredNumberOfTexts) {
        if (benefitTextsWebElements.size() != requiredNumberOfTexts) {
            throw new StaleElementReferenceException("Number of benefit texts is wrong");
        }
    }

    public void checkIfBenefitTextsAreAsExpected(String expectedTexts) {
        List<String> listOfBenefitTexts = benefitTextsWebElements.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());
        List<String> expectedListOfBenefitTexts = Stream.of(expectedTexts.split(" ; ")).map(
            elem -> new String(elem)).collect(Collectors.toList());
        String str2 = expectedListOfBenefitTexts.stream().collect(Collectors.joining("\n"));
        if (!listOfBenefitTexts.equals(expectedListOfBenefitTexts)) {
            throw new StaleElementReferenceException("Displayed and expected benefit texts are not the same");
        }
    }
}
