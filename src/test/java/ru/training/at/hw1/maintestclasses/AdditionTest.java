package ru.training.at.hw1.maintestclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class AdditionTest extends CommonTestContent {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addition data - long",
          groups = "additionAndSubtraction")
    public void additionLongTesting(long firstNum, long secondNum, long expectedResult) {
        long actualResult = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " + " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addition data - double",
          groups = "additionAndSubtraction")
    public void additionDoubleTesting(double firstNum, double secondNum, double expectedResult) {
        double actualResult = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, 0.0001);
        System.out.println(firstNum + " + " + secondNum + " = " + expectedResult);
    }

}
