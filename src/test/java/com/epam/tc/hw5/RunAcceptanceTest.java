package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:/com.epam.tc.hw5/feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
