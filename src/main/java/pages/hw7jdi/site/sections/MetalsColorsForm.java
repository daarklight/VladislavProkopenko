package pages.hw7jdi.site.sections;

import static org.hamcrest.Matchers.equalTo;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.transferListOfResults;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.hamcrest.MatcherAssert;
import pages.hw7jdi.entities.MetalsColorsModel;

public class MetalsColorsForm extends Form<MetalsColorsModel> {

    @UI("[name=custom_radio_odd], [name=custom_radio_even]")
    public static RadioButtons summary;

    @FindBy(css = "section[class=vertical-group] input[type=checkbox]")
    public static Checklist elements;

    @JDropdown(root = ".colors", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown color;

    @JDropdown(root = ".metals", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "div[ui=droplist]", value = "button", list = "li", expand = ".caret")
    public static Dropdown vegetables;

    @Css("button#submit-button")
    public static Button submit;

    @Override
    public void fill(MetalsColorsModel metalsColorsModel) {

        List<Integer> listOfSummary = metalsColorsModel.summary;
        listOfSummary.stream().forEach(elem -> summary.select(String.valueOf(elem)));

        List<String> listOfElements = metalsColorsModel.elements;
        listOfElements.stream().forEach(elem -> elements.select(elem));

        color.select(metalsColorsModel.color);

        metals.select(metalsColorsModel.metals);

        vegetables.select("Vegetables");
        List<String> listOfVegetables = metalsColorsModel.vegetables;
        listOfVegetables.stream().forEach(elem -> vegetables.select(elem));
    }

    @Override
    public void check(MetalsColorsModel metalsColorsModel) {

        int summary = metalsColorsModel.summary.get(0) + metalsColorsModel.summary.get(1);

        List<String> listOfElements = metalsColorsModel.elements;
        String stringOfElements = listOfElements.stream().collect(Collectors.joining(", "));

        List<String> listOfVegetables = metalsColorsModel.vegetables;
        String stringOfVegetables = listOfVegetables.stream().collect(Collectors.joining(", "));

        List<String> expectedResult = Arrays.asList(
            "Summary: " + String.valueOf(summary), "Elements: " + stringOfElements,
            "Color: " + metalsColorsModel.color,
            "Metal: " + metalsColorsModel.metals, "Vegetables: " + stringOfVegetables
        );

        MatcherAssert.assertThat(transferListOfResults(), equalTo(expectedResult));
    }

    @Override
    public void submit() {
        submit.click();
    }
}
