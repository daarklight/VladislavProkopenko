package ru.training.at.hw1.maintestclasses;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class SubtractionTest {

    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void before() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtraction data - long",
          groups = "additionAndSubtraction")
    public void subtractionTesting(long firstNum, long secondNum, long expectedResult) {
        long actualResult = calculator.sub(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " - " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "subtraction data - double",
          groups = "additionAndSubtraction")
    public void subtractionTesting(double firstNum, double secondNum, double expectedResult) {
        double actualResult = calculator.sub(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, 0.0001);
        System.out.println(firstNum + " - " + secondNum + " = " + expectedResult);
    }

    @AfterClass(alwaysRun = true)
    public void after() {
        calculator = null;
    }
}
