package pages.hw7jdi.site.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import pages.hw7jdi.site.sections.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @Css("form")
    public static LoginForm loginForm;
    @Css("img#user-icon")
    public static Icon userIcon;

    @Css("header a[href = 'metals-colors.html']")
    public static Button metalsColors;



}
