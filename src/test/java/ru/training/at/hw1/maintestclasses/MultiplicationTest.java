package ru.training.at.hw1.maintestclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class MultiplicationTest extends CommonTestContent {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multiplication data - long",
          groups = "divisionAndMultiplication")
    public void multiplicationLongTesting(long firstNum, long secondNum, long expectedResult) {
        long actualResult = calculator.mult(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " * " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multiplication data - double",
          groups = "divisionAndMultiplication")
    public void multiplicationDoubleTesting(double firstNum, double secondNum, double expectedResult) {
        double actualResult = calculator.mult(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, 0.0001);
        System.out.println(firstNum + " * " + secondNum + " = " + expectedResult);
    }
}
