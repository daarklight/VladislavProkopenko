package ru.training.at.hw1.mainTestClasses;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class MultiplicationTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multiplication data - long",
          groups = "divisionAndMultiplication")
    public void multiplicationTestingLong(long firstNum, long secondNum, long expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.mult(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " * " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multiplication data - double",
          groups = "divisionAndMultiplication")
    public void multiplicationTestingDouble(double firstNum, double secondNum, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.mult(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " * " + secondNum + " = " + expectedResult);
    }

}
