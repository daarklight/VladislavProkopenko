package ru.training.at.hw1.maintestclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class SubtractionTest extends CommonTestContent {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtraction data - long",
          groups = "additionAndSubtraction")
    public void subtractionLongTesting(long firstNum, long secondNum, long expectedResult) {
        long actualResult = calculator.sub(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " - " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtraction data - double",
          groups = "additionAndSubtraction")
    public void subtractionDoubleTesting(double firstNum, double secondNum, double expectedResult) {
        double actualResult = calculator.sub(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, 0.0001);
        System.out.println(firstNum + " - " + secondNum + " = " + expectedResult);
    }
}
