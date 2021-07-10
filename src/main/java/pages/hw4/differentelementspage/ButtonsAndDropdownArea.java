package pages.hw4.differentelementspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.hw4.AbstractPage;

public class ButtonsAndDropdownArea extends AbstractPage {

    public ButtonsAndDropdownArea(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    private WebElement webElementForWaterCheckbox;

    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    private WebElement webElementForWindCheckbox;

    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    private WebElement webElementForSelenRadioButton;

    @FindBy(xpath = "//div[@class = 'colors']/child::select")
    private WebElement dropdownToChoose;

    public void clickCheckBoxes() {
        webElementForWaterCheckbox.click();
        webElementForWindCheckbox.click();
    }

    public void clickRadioButton() {
        webElementForSelenRadioButton.click();
    }

    public void selectDropdown(String colorFromDropdown) {
        Select dropdown = new Select(dropdownToChoose);
        dropdown.selectByVisibleText(colorFromDropdown);
    }
}
