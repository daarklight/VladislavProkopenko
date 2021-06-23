package ru.training.at.hw2.ex1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.commonsteps.PrepostConditions;

public class Exercise1Test extends PrepostConditions {

    private WebElement webElement;

    @Test
    public void exercise1Test() {
        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        webdriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        softAssert.assertEquals(webdriver.getTitle(), "Home Page");

        // 3. Perform login
        webdriver.findElement(By.cssSelector("li[class='dropdown uui-profile-menu'] > a[class='dropdown-toggle']"))
                 .click();
        webdriver.findElement(By.id("name")).sendKeys("Roman");
        webdriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webdriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        softAssert.assertEquals(webdriver.findElement(By.cssSelector("span[id='user-name']")).getText(),
            "ROMAN IOVLEV");

        // 5. Assert that 4 items on the header section are displayed and have proper texts
        webElement = webdriver.findElement(By.cssSelector("header a[href = 'index.html']"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "HOME");

        webElement = webdriver.findElement(By.cssSelector("header a[href = 'contacts.html']"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "CONTACT FORM");

        webElement = webdriver.findElement(By.cssSelector("header a[class = 'dropdown-toggle']"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "SERVICE");

        webElement = webdriver.findElement(By.cssSelector("header a[href = 'metals-colors.html']"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "METALS & COLORS");

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(webdriver.findElements(By.className("benefit-icon")).size(), 4);

        softAssert.assertTrue(webdriver.findElement(By.cssSelector("span[class='icons-benefit icon-practise']"))
                                       .isDisplayed());
        softAssert.assertTrue(webdriver.findElement(By.cssSelector("span[class='icons-benefit icon-custom']"))
                                       .isDisplayed());
        softAssert.assertTrue(webdriver.findElement(By.cssSelector("span[class='icons-benefit icon-multi']"))
                                       .isDisplayed());
        softAssert.assertTrue(webdriver.findElement(By.cssSelector("span[class='icons-benefit icon-base']"))
                                       .isDisplayed());

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // (According to teacher's recommendations, it was decided to exclude the requirement of
        // searching these 4 texts under the icons. So, each text is searched as is, without
        // any connections to points in space)
        List<WebElement> listOfTextFields = webdriver.findElements(By.className("benefit-txt"));

        softAssert.assertEquals(listOfTextFields.size(), 4);

        softAssert.assertTrue(listOfTextFields.get(0).isDisplayed());
        softAssert.assertEquals(listOfTextFields.get(0).getText(),
            "To include good practices\nand ideas from successful\nEPAM project");

        softAssert.assertTrue(listOfTextFields.get(1).isDisplayed());
        softAssert.assertEquals(listOfTextFields.get(1).getText(), "To be flexible and\ncustomizable");

        softAssert.assertTrue(listOfTextFields.get(2).isDisplayed());
        softAssert.assertEquals(listOfTextFields.get(2).getText(), "To be multiplatform");

        softAssert.assertTrue(listOfTextFields.get(3).isDisplayed());
        softAssert.assertEquals(listOfTextFields.get(3).getText(),
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        // 8. Assert that there is the iframe with “Frame Button” exist
        // (Cause step #9 checks whether “Frame Button” exists in the iframe,
        // it was decided to check only existence of the frame)
        softAssert.assertEquals(webdriver.findElement(By.tagName("iframe")).isDisplayed(), true);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webdriver.switchTo().frame("frame");
        softAssert.assertTrue(webdriver.findElement(By.xpath("//input[@type='button']"
            + "[contains(@value, 'Frame Button')]")).isDisplayed());

        // 10. Switch to original window back
        webdriver.switchTo().defaultContent();

        // 11. Assert that 5 items in the Left Section are displayed and have proper text
        webElement = webdriver.findElement(By.cssSelector("ul[class='sidebar-menu left'] a[href = 'index.html']"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "Home");

        webElement = webdriver.findElement(By.cssSelector("ul[class='sidebar-menu left'] a[href = 'contacts.html']"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "Contact form");

        webElement = webdriver.findElement(By.cssSelector("ul[class='sidebar-menu left'] li[index = '3'] > a"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "Service");

        webElement = webdriver.findElement(By.cssSelector("ul[class='sidebar-menu left'] "
            + "a[href = 'metals-colors.html']"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "Metals & Colors");

        webElement = webdriver
            .findElement(By.cssSelector("ul[class='sidebar-menu left'] li[class='menu-title']:nth-child(5) span"));
        softAssert.assertTrue(webElement.isDisplayed());
        softAssert.assertEquals(webElement.getText(), "Elements packs");

        softAssert.assertAll();
    }
}
