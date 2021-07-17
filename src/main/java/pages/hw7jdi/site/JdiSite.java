package pages.hw7jdi.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import org.openqa.selenium.WebElement;
import pages.hw7jdi.site.pages.HomePage;
import pages.hw7jdi.site.pages.MetalsAndColorsPage;

public class JdiSite {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    @Css(".profile-photo [ui=label]") public static UIElement userName;
    @Css(".logout") public static WebElement logout;

}
