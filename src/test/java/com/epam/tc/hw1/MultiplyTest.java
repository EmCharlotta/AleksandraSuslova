package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class MultiplyTest {

    @Test(groups = {"divmult"},
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "multiplication data")
    public void multiplicationTest(int a, int b, int expected) {
        Calculator calculator = new Calculator();
        AssertionsForClassTypes.assertThat(calculator.mult(a, b)).isEqualTo(expected);
    }
}
