package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "addition data - long")
    public static Object[][] additionDataLong() {
        return new Object[][] {
            {1, 2, 3},
            {2, 2, 4}
        };
    }

    @DataProvider(name = "addition data - double")
    public static Object[][] additionDataDouble() {
        return new Object[][] {
            {1.5, 2.3, 3.8},
            {2.0, 2.5, 4.5}
        };
    }

    @DataProvider(name = "subtraction data - long")
    public static Object[][] subtractionDataLong() {
        return new Object[][] {
            {12, 2, 10},
            {3, 1, 2}
        };
    }

    @DataProvider(name = "subtraction data - double")
    public static Object[][] subtractionDataDouble() {
        return new Object[][] {
            {11.5, 2.0, 9.5},
            {0, -1.5, 1.5}
        };
    }

    @DataProvider(name = "division data - long")
    public static Object[][] divisionDataLong() {
        return new Object[][] {
            {12, 2, 6},
            {6, 2, 3}
        };
    }

    @DataProvider(name = "division data - double")
    public static Object[][] divisionDataDouble() {
        return new Object[][] {
            {20.2, 2, 10.1},
            {6.3, 3, 2.1}
        };
    }

    @DataProvider(name = "multiplication data - long")
    public static Object[][] multiplicationDataLong() {
        return new Object[][] {
            {3, 4, 12},
            {12, 3, 36}
        };
    }

    @DataProvider(name = "multiplication data - double")
    public static Object[][] multiplicationDataDouble() {
        return new Object[][] {
            {3.1, 4.5, 13.95},
            {12.2, 3, 36.6}
        };
    }
}
