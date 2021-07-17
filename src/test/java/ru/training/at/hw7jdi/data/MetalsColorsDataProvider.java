package ru.training.at.hw7jdi.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.DataProvider;
import pages.hw7jdi.entities.MetalsColorsModel;

public class MetalsColorsDataProvider {

    @DataProvider(name = "metalsColorsObjects")
    public static Object[][] metalsColorsObjects() throws IOException {

        File filePath = new File("src/test/resources/JDImetalsColorsDataSet.json");
        FileInputStream fileInputStream = new FileInputStream(filePath);

        String jsonText = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8.name());

        Type itemsMapType = new TypeToken<Map<String, MetalsColorsModel>>() {
        }.getType();

        Map<String, MetalsColorsModel> mapItemsDes = new Gson().fromJson(jsonText, itemsMapType);
        List<MetalsColorsModel> listOfMetalsColorsModel = new ArrayList(mapItemsDes.values());

        MetalsColorsModel[][] arrayOfObjects = new MetalsColorsModel[listOfMetalsColorsModel.size()][1];
        for (int i = 0; i < listOfMetalsColorsModel.size(); i++) {
            MetalsColorsModel mc = listOfMetalsColorsModel.get(i);
            arrayOfObjects[i][0] = mc;
        }
        return arrayOfObjects;
    }
}
