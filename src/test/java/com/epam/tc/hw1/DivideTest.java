package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.Test;

public class DivideTest {

    @Test(groups = {"divmult"},
            dataProviderClass = DataProviderForCalculator.class,
            dataProvider = "division data")

    public void divisionTest(int a, int b, int result) {
        Calculator calculator = new Calculator();
        AssertionsForClassTypes.assertThat(calculator.div(a, b)).isEqualTo(result);
    }
}
