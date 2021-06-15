package ru.training.at.hw1.maintestclasses;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.training.at.hw1.DataProviders;

public class AdditionTest {

    private Calculator calculator;

    @BeforeTest(alwaysRun = true)
    public void before() {
        calculator = new Calculator();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addition data - long",
          groups = "additionAndSubtraction")
    public void additionTestingLong(long firstNum, long secondNum, long expectedResult) {
        long actualResult = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(firstNum + " + " + secondNum + " = " + expectedResult);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addition data - double",
          groups = "additionAndSubtraction")
    public void additionTestingDouble(double firstNum, double secondNum, double expectedResult) {
        double actualResult = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, 0.0001);
        System.out.println(firstNum + " + " + secondNum + " = " + expectedResult);
    }

    @AfterTest(alwaysRun = true)
    public void after() {
        calculator = null;
    }

}
