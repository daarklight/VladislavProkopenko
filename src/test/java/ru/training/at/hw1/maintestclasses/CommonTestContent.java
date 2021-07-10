package ru.training.at.hw1.maintestclasses;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTestContent {

    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        calculator = null;
    }
}
