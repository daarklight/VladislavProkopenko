package ru.training.at.hw1.mainTestClasses;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class SubtractionTest {
    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtraction data - long",
          groups = "additionAndSubtraction")
    public void subtractionTesting(long firstNum, long secondNum, long expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.sub(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " - " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtraction data - double",
          groups = "additionAndSubtraction")
    public void subtractionTesting(double firstNum, double secondNum, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.sub(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " - " + secondNum + " = " + expectedResult);
    }
}
