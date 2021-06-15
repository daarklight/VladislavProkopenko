package ru.training.at.hw1.maintestclasses;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class DivisionTest {

    private Calculator calculator;

    @BeforeClass
    public void before() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "division data - long",
          groups = "divisionAndMultiplication")
    public void divisionTestingLong(long firstNum, long secondNum, long expectedResult) {
        long actualResult = calculator.div(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " / " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "division data - double",
          groups = "divisionAndMultiplication")
    public void divisionTestingDouble(double firstNum, double secondNum, double expectedResult) {
        double actualResult = calculator.div(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, 0.0001);
        System.out.println(firstNum + " / " + secondNum + " = " + expectedResult);
    }

    @AfterClass
    public void after() {
        calculator = null;
    }
}
