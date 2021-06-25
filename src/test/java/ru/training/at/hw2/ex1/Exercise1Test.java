package ru.training.at.hw2.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.commonsteps.PrepostConditions;

public class Exercise1Test extends PrepostConditions {

    public static final int numberOfTextFieldsAndImages = 4;
    private WebElement webElement;

    @Test
    public void exercise1Test() {
        SoftAssert softAssert = new SoftAssert();

        // 1. Open test site by URL
        webdriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        softAssert.assertEquals(webdriver.getTitle(), "Home Page");

        // 3. Perform login
        webdriver.findElement(By.cssSelector("li.dropdown.uui-profile-menu > a.dropdown-toggle")).click();
        webdriver.findElement(By.id("name")).sendKeys("Roman");
        webdriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webdriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is logged in
        softAssert.assertEquals(webdriver.findElement(By.cssSelector("span#user-name")).getText(),
            "ROMAN IOVLEV");

        // 5. Assert that 4 items on the header section are displayed and have proper texts
        List<String> cssSelectorsForHeaderItems = Arrays.asList(
            "header a[href = 'index.html']", "header a[href = 'contacts.html']",
            "header a.dropdown-toggle", "header a[href = 'metals-colors.html']");

        List<String> listOfNamesForHeaderItems = cssSelectorsForHeaderItems.stream().map(
            elem -> webdriver.findElement(By.cssSelector(elem)).getText()).collect(Collectors.toList());

        cssSelectorsForHeaderItems.stream().forEach(elem ->
            softAssert.assertTrue(webdriver.findElement(By.cssSelector(elem)).isDisplayed()));

        List<String> expectedListOfNamesForHeaderItems = Arrays.asList(
            "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        softAssert.assertEquals(listOfNamesForHeaderItems, expectedListOfNamesForHeaderItems);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<String> cssSelectorsForImages = Arrays.asList(
            "span.icons-benefit.icon-practise", "span.icons-benefit.icon-custom",
            "span.icons-benefit.icon-multi", "span.icons-benefit.icon-base");

        softAssert.assertEquals(webdriver.findElements(By.className("benefit-icon")).size(),
            numberOfTextFieldsAndImages);
        cssSelectorsForImages.stream().forEach(elem -> softAssert.assertTrue(
            webdriver.findElement(By.cssSelector(elem)).isDisplayed()));

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // (According to teacher's recommendations, it was decided to exclude the requirement of
        // searching these 4 texts under the icons. So, each text is searched as is, without
        // any connections to points in space)
        List<WebElement> listOfWebElementUnderIconsTextFields = webdriver.findElements(By.className("benefit-txt"));

        List<String> listOfUnderIconsTextFields = listOfWebElementUnderIconsTextFields.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());

        List<String> expectedListOfUnderIconsTextFields = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        softAssert.assertEquals(listOfWebElementUnderIconsTextFields.size(), numberOfTextFieldsAndImages);
        listOfWebElementUnderIconsTextFields.stream().forEach(elem -> softAssert.assertTrue(elem.isDisplayed()));
        softAssert.assertEquals(listOfUnderIconsTextFields, expectedListOfUnderIconsTextFields);

        // 8. Assert that the iframe with “Frame Button” exists
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
        List<String> cssSelectorsForLeftSectionMenu = Arrays.asList("ul.sidebar-menu.left a[href = 'index.html']",
            "ul.sidebar-menu.left a[href = 'contacts.html']",
            "ul.sidebar-menu.left li[index = '3'] > a",
            "ul.sidebar-menu.left a[href = 'metals-colors.html']",
            "ul.sidebar-menu.left li.menu-title:nth-child(5) span");

        List<WebElement> listOfWebElementsLeftSectionItems = cssSelectorsForLeftSectionMenu.stream().map(
            elem -> webdriver.findElement(By.cssSelector(elem))).collect(Collectors.toList());

        listOfWebElementsLeftSectionItems.stream().forEach(
            elem -> softAssert.assertTrue(elem.isDisplayed()));

        List<String> listOfLeftSectionItemNames = listOfWebElementsLeftSectionItems.stream().map(
            elem -> elem.getText()).collect(Collectors.toList());

        List<String> expectedListOfLeftSectionItemNames = Arrays.asList(
            "Home", "Contact form", "Service", "Metals & Colors", "Elements packs");

        softAssert.assertEquals(listOfLeftSectionItemNames, expectedListOfLeftSectionItemNames);

        softAssert.assertAll();
    }
}
