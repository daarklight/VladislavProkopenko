package ru.training.at.hw1.mainTestClasses;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class AdditionTest {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addition data - long",
          groups = "additionAndSubtraction")
    public void additionTestingLong(long firstNum, long secondNum, long expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " + " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addition data - double",
          groups = "additionAndSubtraction")
    public void additionTestingDouble(double firstNum, double secondNum, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " + " + secondNum + " = " + expectedResult);
    }

}
