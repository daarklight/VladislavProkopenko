package ru.training.at.hw1.mainTestClasses;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class DivisionTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "division data - long",
          groups = "divisionAndMultiplication")
    public void divisionTestingLong(long firstNum, long secondNum, long expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.div(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " / " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "division data - double",
          groups = "divisionAndMultiplication")
    public void divisionTestingDouble(double firstNum, double secondNum, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.div(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " / " + secondNum + " = " + expectedResult);
    }
}
