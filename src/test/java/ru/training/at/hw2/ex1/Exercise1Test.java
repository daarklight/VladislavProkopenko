package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.commonsteps.PrepostConditions;

public class Exercise1Test extends PrepostConditions {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void exercise1Test() {

        // 1. Open test site by URL
        webdriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        // 2. Assert Browser title
        softAssert.assertEquals(webdriver.getTitle(), "Home Page");

        // 3. Perform login
        webdriver.findElement(By.xpath("//li[@class='dropdown uui-profile-menu']/a[@class='dropdown-toggle']"))
                 .click();
        webdriver.findElement(By.id("name")).sendKeys("Roman");
        webdriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webdriver.findElement(By.id("login-button")).click();

        // 4. Assert Username is loggined
        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[@id='user-name']")).getText(),
            "ROMAN IOVLEV");

        // 5. Assert that 4 items on the header section are displayed and have proper texts
        softAssert.assertEquals(webdriver.findElement(By.linkText("Home")).isDisplayed(), true);
        softAssert.assertEquals(webdriver.findElement(By.linkText("Contact form")).isDisplayed(), true);
        softAssert.assertEquals(webdriver.findElement(By.className("dropdown-toggle")).getText(), "SERVICE");
        softAssert.assertEquals(webdriver.findElement(By.linkText("Metals & Colors")).isDisplayed(), true);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[@class=\"icons-benefit icon-practise\"]"))
                                         .isDisplayed(), true);
        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[@class=\"icons-benefit icon-custom\"]"))
                                         .isDisplayed(), true);
        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[@class=\"icons-benefit icon-multi\"]"))
                                         .isDisplayed(), true);
        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[@class=\"icons-benefit icon-base\"]"))
                                         .isDisplayed(), true);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // (According to teacher's recommendations, it was decided to exclude the requirement of
        // searching these 4 texts under the icons. So, each text is searched as is, without
        // any connections to points in space)
        softAssert.assertEquals(
            webdriver.findElement(By.xpath("//span[text()='To include good practices' "
                + "and text()='and ideas from successful' and text()='EPAM project']"))
                     .isDisplayed(), true);
        softAssert.assertEquals(
            webdriver.findElement(By.xpath("//span[text()='To be flexible and' and text()='customizable ']"))
                     .isDisplayed(), true);
        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[text()='To be multiplatform ']"))
                                         .isDisplayed(), true);
        softAssert.assertEquals(
            webdriver.findElement(By.xpath("//span[text()='Already have good base' "
                + "and text()='(about 20 internal and' and text()='some external projects),' "
                + "and text()='wish to get more…']")).isDisplayed(), true);

        // 8. Assert that there is the iframe with “Frame Button” exist
        // (Cause step #9 checks whether “Frame Button” exists in the iframe,
        // it was decided to check only existence of the frame)
        softAssert.assertEquals(webdriver.findElement(By.tagName("iframe")).isDisplayed(), true);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webdriver.switchTo().frame("frame");
        softAssert.assertEquals(webdriver.findElement(By.xpath("//input[@type='button']"
            + "[contains(@value, 'Frame Button')]")).isDisplayed(), true);

        // 10. Switch to original window back
        webdriver.switchTo().defaultContent();

        // 11. Assert that 5 items in the Left Section are displayed and have proper text
        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[text()='Home']"))
                                         .isDisplayed(), true);

        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[text()='Contact form']"))
                                         .isDisplayed(), true);

        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[text()='Service']"))
                                         .isDisplayed(), true);

        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[text()='Metals & Colors']"))
                                         .isDisplayed(), true);

        softAssert.assertEquals(webdriver.findElement(By.xpath("//span[text()='Elements packs']"))
                                         .isDisplayed(), true);

        softAssert.assertAll();
    }

}
