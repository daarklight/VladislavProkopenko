package pages.differentelementspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ButtonsAndDropdownArea {

    @FindBy(xpath = "//label[text()[contains(.,'Water')]]/input")
    public WebElement webElementForCheckbox1;

    @FindBy(xpath = "//label[text()[contains(.,'Wind')]]/input")
    public WebElement webElementForCheckbox2;

    public void clickCheckBoxes() {
        webElementForCheckbox1.click();
        webElementForCheckbox2.click();
    }

    @FindBy(xpath = "//label[text()[contains(.,'Selen')]]/input")
    public WebElement radioButton;

    public void clickRadioButton() {
        radioButton.click();
    }

    @FindBy(xpath = "//div[@class = 'colors']/child::select")
    public WebElement dropdownToChoose;

    public void selectDropdown(String colorFromDropdown) {
        Select dropdown = new Select(dropdownToChoose);
        dropdown.selectByVisibleText(colorFromDropdown);
    }
}
