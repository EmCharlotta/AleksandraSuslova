package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class SumTest {

    @Test(groups = "default",
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "sum data")
    public void sumTest(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        AssertionsForClassTypes.assertThat(calculator.sum(a, b)).isEqualTo(expected);
    }
}
