package ru.training.at.hw7jdi.tests;

import static pages.hw7jdi.site.JdiSite.homePage;
import static pages.hw7jdi.site.pages.HomePage.loginForm;
import static pages.hw7jdi.site.pages.HomePage.metalsColors;
import static pages.hw7jdi.site.pages.HomePage.userIcon;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.colorsDropdown;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.elementsChecklist;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.metalsDropdown;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.submitButton;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.summaryRadiobuttonBottomLine;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.summaryRadiobuttonTopLine;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.textRes;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.transferListOfResuls;
import static pages.hw7jdi.site.pages.MetalsAndColorsPage.vegetablesDropdown;
import static ru.training.at.hw7jdi.data.UserData.DEFAULT_USER;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Yellow;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.hw7jdi.entities.MetalsColorsModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MainTest implements TestInit {

    @BeforeTest
    public void workWithJson() throws IOException {

        File filePath = new File("src/test/resources/JDImetalsColorsDataSet.json");
        FileInputStream fileInputStream = new FileInputStream(filePath);

        String jsonText = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8.name());

        Type itemsMapType = new TypeToken<Map<String, MetalsColorsModel>>() {
        }.getType();

        Map<String, MetalsColorsModel> mapItemsDes = new Gson().fromJson(jsonText, itemsMapType);
        List<MetalsColorsModel> listOfMetalsColorsModel = new ArrayList(mapItemsDes.values());

        //        MetalsColorsModel mc1 = listOfMetalsColorsModel.get(1);
        //
        //        System.out.println("colors from Json: " + mc1.metals);
    }

    @Test
    public void mainTest() throws IOException {

        File filePath = new File("src/test/resources/JDImetalsColorsDataSet.json");
        FileInputStream fileInputStream = new FileInputStream(filePath);

        String jsonText = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8.name());

        Type itemsMapType = new TypeToken<Map<String, MetalsColorsModel>>() {
        }.getType();

        Map<String, MetalsColorsModel> mapItemsDes = new Gson().fromJson(jsonText, itemsMapType);
        List<MetalsColorsModel> listOfMetalsColorsModel = new ArrayList(mapItemsDes.values());

        int n = 3;

        // Login:
        homePage.open();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();

        // Open Metals & Colors Page
        metalsColors.click();

        // Fill Summary
        summaryRadiobuttonTopLine.select(String.valueOf(listOfMetalsColorsModel.get(n).summary.get(0)));
        summaryRadiobuttonBottomLine.select(String.valueOf(listOfMetalsColorsModel.get(n).summary.get(1)));

        // Fill checklist of Elements
        List<String> listOfElements = listOfMetalsColorsModel.get(n).elements;
        listOfElements.stream().forEach(element -> elementsChecklist.select(element));

        // Fill Colors
        colorsDropdown.select(listOfMetalsColorsModel.get(n).color);

        // Fill Metals
        metalsDropdown.select(listOfMetalsColorsModel.get(n).metals);

        // Fill Vegetables
        vegetablesDropdown.select("Vegetables");
        List<String> listOfVegetables = listOfMetalsColorsModel.get(n).vegetables;
        listOfVegetables.stream().forEach(elem -> vegetablesDropdown.select(elem));
        //        vegetablesDropdown.select(listOfMetalsColorsModel.get(n).vegetables.spliterator());
        //
        //        // Submit Metals & Colors form
        //        submitButton.click();

        //        // Open Metals & Colors
        //        metalsColors.click();

        //        // Fill Summary
        //        summaryRadiobuttonTopLine.select(String.valueOf(3));
        //        summaryRadiobuttonBottomLine.select(String.valueOf(8));

        //        // Fill checklist of Elements
        //        elementsChecklist.select("Water", "Wind");

        //        // Fill Colors
        //        colorsDropdown.select("Yellow");
        //
        //        // Fill Metals
        //        metalsDropdown.select("Gold");

        //        // Fill Vegetables
        //                vegetablesDropdown.select("Vegetables");
        //                vegetablesDropdown.select("Cucumber", "Tomato");

        // Submit Metals & Colors form
        submitButton.click();

        // Check submitted results

        //        System.out.println("results: " + resultTexts.getLines());

        //        String s1 = "one";
        //        String s2 = "two";
        //        assertThat(s1, containsString(s3));
        //        assertThat(s1, containsString(s4));

        //        List<String> lcol = Arrays.asList("Yellow", "Green");
        //        System.out.println(lcol);

        //        // Correct results table:
        //        System.out.println(transferListOfResuls());

        //        lcol.stream().forEach(elem -> assertThat(transferListOfResuls(), contains()));

        int summary = listOfMetalsColorsModel.get(n).summary.get(0) + listOfMetalsColorsModel.get(n).summary.get(1);
        String stringOfElements = listOfElements.stream().collect(Collectors.joining(", "));
        String stringOfVegetables = listOfVegetables.stream().collect(Collectors.joining(", "));
        List<String> expectedResult = Arrays.asList(
            "Summary: " + String.valueOf(summary), "Elements: " + stringOfElements,
            "Color: " + listOfMetalsColorsModel.get(n).color,
            "Metal: " + listOfMetalsColorsModel.get(n).metals, "Vegetables: " + stringOfVegetables
        );
        //
        //        System.out.println(expectedResult);


        assertThat(transferListOfResuls(), is(expectedResult));

    }
}
