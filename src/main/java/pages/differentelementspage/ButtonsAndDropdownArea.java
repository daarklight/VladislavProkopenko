package pages.differentelementspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ButtonsAndDropdownArea {

    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    public WebElement waterCheckBoxWebElement;

    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    public WebElement windCheckBoxWebElement;

    public void clickCheckBoxes() {
        waterCheckBoxWebElement.click();
        windCheckBoxWebElement.click();
    }

    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    public WebElement selenRadioButton;

    public void clickRadioButton() {
        selenRadioButton.click();
    }

    @FindBy(xpath = "//div[@class = 'colors']/child::select")
    public WebElement dropdownToChoose;

    public void selectDropdown(String colorFromDropdown) {
        Select dropdown = new Select(dropdownToChoose);
        dropdown.selectByVisibleText(colorFromDropdown);
    }
}
