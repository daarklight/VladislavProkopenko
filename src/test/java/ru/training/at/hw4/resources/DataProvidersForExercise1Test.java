package ru.training.at.hw4.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class DataProvidersForExercise1Test {

    @DataProvider(name = "Data for Exercise1Test")
    public static Object[][] dataForTheTests() throws IOException {

        Properties properties = new Properties();
        File filePath = new File("src/test/resources/PageData.properties");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        properties.load(new InputStreamReader(fileInputStream, Charset.forName("windows-1252")));

        return new Object[][] {
            {properties.getProperty("mainPageURL"),
                properties.getProperty("titleForMainPage"),
                properties.getProperty("username"),
                properties.getProperty("password"),
                properties.getProperty("displayedUsername"),
                List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"),
                Integer.parseInt(properties.getProperty("expectedNumberOfTextFieldsAndImages")),
                List.of("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"),
                properties.getProperty("iframeName"),
                List.of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs")
            },
        };
    }
}
