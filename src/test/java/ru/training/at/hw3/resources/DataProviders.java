package ru.training.at.hw3.resources;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Names of Left Menu Items")
    public static Object[][] expectedNamesOfLeftMenuItems() {
        return new Object[][] {
            {"Home ; Contact form ; Service ; Metals & Colors ; Elements packs"}
        };
    }

    @DataProvider(name = "Names of Header Menu Items")
    public static Object[][] expectedNamesOfHeaderMenuItems() {
        return new Object[][] {
            {"HOME ; CONTACT FORM ; SERVICE ; METALS & COLORS"}
        };
    }

    @DataProvider(name = "Benefit Texts")
    public static Object[][] expectedBenefitTexts() {
        return new Object[][] {
            {"To include good practices\nand ideas from successful\nEPAM project ;"
                  + " To be flexible and\ncustomizable ; To be multiplatform ;"
                  + " Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @DataProvider(name = "Texts in Log")
    public static Object[][] expectedLogRowsTexts() {
        return new Object[][] {
            {"Colors: value changed to Yellow ; metal: value changed to Selen ; "
                  + "Wind: condition changed to true ; Water: condition changed to true"}
        };
    }
}

