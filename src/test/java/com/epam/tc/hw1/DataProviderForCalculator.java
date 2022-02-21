package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderForCalculator {

    @DataProvider(name = "sum data")
    public static Object[][] getTestDataForAddition() {
        return new Object[][]{
                {2, 2, 4},
                {1, 2, 3},
                {0, 6, 6}
        };
    }

    @DataProvider(name = "division data")
    public static Object[][] getTestDataForDivision() {
        return new Object[][]{
            {2, 2, 1},
            {4, 2, 2},
            {10, 2, 5}
        };
    }

    @DataProvider(name = "multiplication data")
    public static Object[][] getTestDataForMultiplication() {
        return new Object[][]{
            {2, 2, 4},
            {1, 2, 2},
            {0, 6, 0}
        };
    }

    @DataProvider(name = "subtraction data")
    public static Object[][] getTestDataForSubtraction() {
        return new Object[][]{
            {2, 2, 0},
            {1, 2, -1},
            {10, 6, 4}
        };
    }

}
