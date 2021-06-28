package ru.training.at.hw1.maintestclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class DivisionTest extends CommonTestContent {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "division data - long",
          groups = "divisionAndMultiplication")
    public void divisionLongTesting(long firstNum, long secondNum, long expectedResult) {
        long actualResult = calculator.div(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " / " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "division data - double",
          groups = "divisionAndMultiplication")
    public void divisionDoubleTesting(double firstNum, double secondNum, double expectedResult) {
        double actualResult = calculator.div(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, 0.0001);
        System.out.println(firstNum + " / " + secondNum + " = " + expectedResult);
    }
}
