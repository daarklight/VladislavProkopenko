package ru.training.at.hw2.ex2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw2.commonsteps.PrepostConditions;

public class Exercise2Test extends PrepostConditions {

    public static final int numberOfUniqueElement = 1;
    private WebElement webElement;

    @Test
    public void exercise2Test() {

        // 1. Open test site by URL
        webdriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        Assert.assertEquals(webdriver.getTitle(), "Home Page");

        // 3. Perform login
        webdriver.findElement(By.cssSelector("li.dropdown.uui-profile-menu > a.dropdown-toggle")).click();
        webdriver.findElement(By.id("name")).sendKeys("Roman");
        webdriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webdriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is logged in
        Assert.assertEquals(webdriver.findElement(By.cssSelector("span#user-name")).getText(),
            "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        webdriver.findElement(By.cssSelector("header a.dropdown-toggle")).click();
        webdriver.findElement(By.cssSelector("header a[href = 'different-elements.html']")).click();

        // 6. Select checkboxes
        webdriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input")).click();
        webdriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input")).click();

        // 7. Select radio
        webdriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input")).click();

        // 8. Select in dropdown
        webElement = webdriver.findElement(By.xpath("//div[@class = 'colors']/child::select"));
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText("Yellow");

        // 9. Assert that:
        // - for each checkbox there is an individual log row and value is corresponded to the status of checkbox;
        // - for radio button there is a log row and value is corresponded to the status of radio button;
        // - for dropdown there is a log row and value is corresponded to the selected value;
        List<WebElement> listForRadioButton = webdriver
            .findElements(By.xpath(
                "//div[@class = 'info-panel-section']//child::li[contains(text(), 'value changed to') "
                    + "and contains(text(), 'Selen')]"));
        Assert.assertEquals(listForRadioButton.size(), numberOfUniqueElement);

        List<WebElement> listForCheckBox1 = webdriver
            .findElements(By.xpath(
                "//div[@class = 'info-panel-section']//child::li[contains(text(), 'Water') "
                    + "and contains(text(), 'true')]"));
        Assert.assertEquals(listForCheckBox1.size(), numberOfUniqueElement);

        List<WebElement> listForCheckBox2 = webdriver
            .findElements(By.xpath(
                "//div[@class = 'info-panel-section']//child::li[contains(text(), 'Wind') "
                    + "and contains(text(), 'true')]"));
        Assert.assertEquals(listForCheckBox2.size(), numberOfUniqueElement);

        List<WebElement> listForDropdown = webdriver
            .findElements(By.xpath(
                "//div[@class = 'info-panel-section']//child::li[contains(text(), 'value changed to Yellow')]"));
        Assert.assertEquals(listForDropdown.size(), numberOfUniqueElement);
    }
}
