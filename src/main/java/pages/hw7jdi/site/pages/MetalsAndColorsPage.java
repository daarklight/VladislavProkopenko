package pages.hw7jdi.site.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {

    @UI("[name=custom_radio_odd]")
    public static RadioButtons summaryRadiobuttonTopLine;

    @UI("[name=custom_radio_even]")
    public static RadioButtons summaryRadiobuttonBottomLine;

    @Css("button#submit-button")
    public static Button submitButton;

    @JDropdown(root = ".colors", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown colorsDropdown;

    @JDropdown(root = ".metals", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown metalsDropdown;

    @JDropdown(root = "div[ui=droplist]", value = "button", list = "li", expand = ".caret")
    public static Dropdown vegetablesDropdown;

    @FindBy(css = "section[class=vertical-group] input[type=checkbox]")
    public static Checklist elementsChecklist;

    //    //@FindBy(id = "multi-dropdown")
    //    @UI("#multi-dropdown")
    //    public static MultiSelector multiDropdown;
    //    @UI("div[ui=droplist]")
    //    public static MultiSelector vegetablesMultiDropdown;
    //    @Css("div[ui=droplist]")
    //    public static MultiSelector vegetables;

    //    @XPath(".//button[@type='submit' and contains(.,'Calculate')]") public Button calculate;

    @UI("ul.panel-body-list.results > li")
    public static List<Text> textRes;

    public static List<String> transferListOfResuls() {
        return textRes.stream().map(elem -> elem.getText()).collect(Collectors.toList());
    }
}
