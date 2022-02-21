package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class SubtractTest {

    @Test(groups = {"default"},
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "subtraction data")
    public void subtractionTest(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        AssertionsForClassTypes.assertThat(calculator.sub(a, b)).isEqualTo(expected);
    }
}
