package pages.mainpage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BottomPicturesAndTexts {

    @FindBy(css = "div.benefit > div.benefit-icon")
    private List<WebElement> benefitImagesWebElements;

    @FindBy(css = "div.benefit > span.benefit-txt")
    private List<WebElement> benefitTextsWebElements;

    public void checkNumberOfImages(int requiredNumberOfImages) {
        if (benefitImagesWebElements.size() != requiredNumberOfImages) {
            throw new NoSuchElementException("Number of benefit images is wrong");
        }
    }

    public void checkIfAllImagesAreDisplayed() {
        benefitImagesWebElements.stream().forEach(elem -> {
            if (!elem.isDisplayed()) {
                throw new NoSuchElementException("Benefit images are not displayed");
            }
        });
    }

    public List<String> transferListOfBenefitTexts() {
        return benefitTextsWebElements.stream().map(elem -> elem.getText()).collect(Collectors.toList());
    }
}
