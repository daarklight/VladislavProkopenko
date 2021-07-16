package ru.training.at.hw6.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.DataProvider;

public class DataProvidersForExercise2Test {

    @DataProvider(name = "Data for Exercise2Test")
    public static Object[][] dataForTheTests() throws IOException {

        Properties properties = new Properties();
        File filePath = new File("src/test/resources/PageData.properties");
        FileInputStream fileInputStream = new FileInputStream(filePath);
        properties.load(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));

        return new Object[][]
            {
                {
                    properties.getProperty("mainPageURL"),
                    properties.getProperty("titleForMainPage"),
                    properties.getProperty("username"),
                    properties.getProperty("password"),
                    properties.getProperty("displayedUsername"),
                    properties.getProperty("colorFromDropdown"),
                    List.of("Colors: value changed to Yellow", "metal: value changed to Selen",
                        "Wind: condition changed to true", "Water: condition changed to true"),
                },
            };
    }
}
